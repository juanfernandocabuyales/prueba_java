package com.credibanco.assessment.card.api.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@ComponentScan(basePackages = { "com.credibanco.assessment.card"})
@EntityScan("com.credibanco.assessment.card.model")
@EnableJpaRepositories("com.credibanco.assessment.card.repository")
public class PruebaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaBackApplication.class, args);
	}

}
