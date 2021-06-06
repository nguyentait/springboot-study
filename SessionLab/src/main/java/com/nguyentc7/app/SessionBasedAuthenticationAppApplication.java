package com.nguyentc7.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionBasedAuthenticationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionBasedAuthenticationAppApplication.class, args);
		System.out.println("Hello world");
	}

}
