package com.example.demosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class DemoSecurityApplication {

	public static void main(String[] args) {
		System.out.println("Hello Security!!!!!");
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

}
