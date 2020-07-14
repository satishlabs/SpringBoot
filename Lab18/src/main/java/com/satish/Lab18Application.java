package com.satish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.satish"})
public class Lab18Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Lab18Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder appliication) {
		return appliication.sources(Lab18Application.class);
	}
}
