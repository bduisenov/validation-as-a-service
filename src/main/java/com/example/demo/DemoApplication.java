package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.function.Function;

import static java.lang.System.out;

@SpringBootApplication
public class DemoApplication {

    @Resource
    private Function<String, Optional<String>> emailValidation;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            out.println("#################################### started ####################################");
            out.println(emailValidation.apply("some@email.com"));
            out.println(emailValidation.apply("wrong.val"));
            out.println("#################################### done ####################################");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
