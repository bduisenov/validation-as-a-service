package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.function.Function;

import static java.lang.System.out;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private Function<String, Boolean> hasLowerCase;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            out.println("#################################### started ####################################");
            out.println(hasLowerCase.apply("true"));
            out.println(hasLowerCase.apply("FALSE"));
            out.println("#################################### done ####################################");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
