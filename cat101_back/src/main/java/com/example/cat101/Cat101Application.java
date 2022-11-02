package com.example.cat101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@EnableCaching
@SpringBootApplication
public class Cat101Application {

    public static void main(String[] args) {
        SpringApplication.run(Cat101Application.class, args);
    }

}
