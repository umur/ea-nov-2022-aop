package com.example.lab3springdata;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EntityScan("com.example.lab3springdata.model.uni_directional")
public class Lab3SpringDataApplication {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


    public static void main(String[] args) {
        SpringApplication.run(Lab3SpringDataApplication.class, args);
    }


}
