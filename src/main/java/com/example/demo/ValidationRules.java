package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("validation")
public class ValidationRules {

    Map<String, Rule> rules;

    public Map<String, Rule> getRules() {
        return rules;
    }

    public void setRules(Map<String, Rule> rules) {
        this.rules = rules;
    }

    public static class Rule {
        String in;

        String out;

        String lambda;

        public String getIn() {
            return in;
        }

        public void setIn(String in) {
            this.in = in;
        }

        public String getOut() {
            return out;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public String getLambda() {
            return lambda;
        }

        public void setLambda(String lambda) {
            this.lambda = lambda;
        }
    }

}
