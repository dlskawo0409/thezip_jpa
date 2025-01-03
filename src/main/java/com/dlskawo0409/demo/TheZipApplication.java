package com.dlskawo0409.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TheZipApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheZipApplication.class, args);
	}

}
