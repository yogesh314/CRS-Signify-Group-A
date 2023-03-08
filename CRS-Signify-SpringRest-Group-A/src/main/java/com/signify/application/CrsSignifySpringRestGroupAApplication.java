package com.signify.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.signify.*") // this annotation scan all the spring component like bean, DAO, RestController etc . based on package patterns
@EnableWebMvc
@SpringBootApplication	
public class CrsSignifySpringRestGroupAApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsSignifySpringRestGroupAApplication.class, args);
		System.out.println("Running");
	}

}
