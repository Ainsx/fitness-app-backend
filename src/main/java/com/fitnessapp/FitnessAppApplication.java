package com.fitnessapp;

import com.fitnessapp.model.User;
import com.fitnessapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
// adds
// @Configuration
// 1. Configuration : Tags the class as a source of bean definitions for the
// application context
// @EnableAutoConfiguration
// 2. EnableAutoConfiguration
// - Tells spring boot to start adding beans based on classpath settings, other
// beans and various property settings.
// @ComponentScan
// 3. ComponenetScan : Tells spring to look for other components,
// configurations, and services in
// letting it find the controllers
public class FitnessAppApplication {

	public static void main(String[] args) {// start program here
		SpringApplication.run(FitnessAppApplication.class, args);
	}

	@Autowired
	private PasswordEncoder encoder;

	/*
	 * Testing data purpose
	 * Running one time set up logic
	 * Debug logging/ checks during dev
	 */
	@Bean // injected object from User repo
	CommandLineRunner run(UserRepository repo) {//
		return args -> {
			// repo -> reference
			if (repo.findByEmail("testUser1@gmail.com").isEmpty()) {
				String hashed = encoder.encode("securepass123");
				repo.save(new User("testUser", hashed, "testUser1@gmail.com"));
				System.out.println("testUser saving to database");
			}
		};
	}
}
