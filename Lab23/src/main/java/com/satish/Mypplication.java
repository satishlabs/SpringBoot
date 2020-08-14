package com.satish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.satish"})
@EnableSwagger2 
public class Mypplication {

	public static void main(String[] args) {
		SpringApplication.run(Mypplication.class, args);
	}

}
