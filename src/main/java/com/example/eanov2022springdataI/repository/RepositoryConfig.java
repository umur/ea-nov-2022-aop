package com.example.eanov2022springdataI.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(
        basePackages = {"com.example.eanov2022springdataI.repository"},
        repositoryBaseClass = CrudRepository.class
)

public class RepositoryConfig {
}
