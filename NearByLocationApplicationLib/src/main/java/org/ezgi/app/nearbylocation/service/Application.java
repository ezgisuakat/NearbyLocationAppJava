package org.ezgi.app.nearbylocation.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "org.ezgi")
@EnableJpaRepositories(basePackages = "org.ezgi")
@EntityScan(basePackages = "org.ezgi")
public class Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}