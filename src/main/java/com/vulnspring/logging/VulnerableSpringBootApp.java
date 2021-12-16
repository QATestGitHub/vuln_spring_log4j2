package com.vulnspring.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VulnerableSpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(VulnerableSpringBootApp.class, args);
	}

}
