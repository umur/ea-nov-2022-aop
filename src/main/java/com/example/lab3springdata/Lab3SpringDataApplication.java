package com.example.lab3springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.lab3springdata.model.uni_directional")
public class Lab3SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab3SpringDataApplication.class, args);
    }


}
