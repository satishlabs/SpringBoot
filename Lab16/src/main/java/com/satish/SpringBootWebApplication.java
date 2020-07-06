package com.satish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@EnableWebMvc
@EnableWebSecurity
@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer
{
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(SpringBootWebApplication.class); }
	 */

	public static void main( String[] args )
	{
		SpringApplication.run(SpringBootWebApplication.class, args);
		System.out.println("Hello $$$$$$$$$$$$$$$$$$$$$");
	}

}
