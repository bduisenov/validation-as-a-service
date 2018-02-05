package com.example.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.function.compiler.FunctionCompiler;
import org.springframework.cloud.function.compiler.proxy.LambdaCompilingFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Configuration
@EnableConfigurationProperties(ValidationRules.class)
public class ValidationConfig {

    @Bean
    public Map<String, Function<Object, Boolean>> validations(FunctionCompiler<Object, Boolean> compiler, ValidationRules rules) {
        return rules.rules.entrySet().stream().collect(toMap(Map.Entry::getKey, e -> {
            ValidationRules.Rule rule = e.getValue();
            String lambda = rule.lambda;
            LambdaCompilingFunction<Object, Boolean> function = new LambdaCompilingFunction<>(new ByteArrayResource(lambda.getBytes()), compiler);
            try {
                function.setTypeParameterizations(rule.in, rule.out);
                function.setBeanName("rule");
                function.afterPropertiesSet();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return function;
        }));
    }

    @Bean
    public <T, R> FunctionCompiler<T, R> compiler() {
        return new FunctionCompiler<>();
    }

}
