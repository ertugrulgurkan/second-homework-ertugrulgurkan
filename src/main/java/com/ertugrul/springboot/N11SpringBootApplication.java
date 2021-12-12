package com.ertugrul.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class N11SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(N11SpringBootApplication.class, args);
    }

}
