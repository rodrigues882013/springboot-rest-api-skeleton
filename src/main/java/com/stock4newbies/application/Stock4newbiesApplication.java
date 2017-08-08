package com.stock4newbies.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.stock4newbies"})
@EnableJpaRepositories("com.stock4newbies")
@EntityScan("com.stock4newbies")
public class Stock4newbiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Stock4newbiesApplication.class, args);
	}
}
