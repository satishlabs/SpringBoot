package com.satish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.satish"})
public class Mypplication {

	public static void main(String[] args) {
		SpringApplication.run(Mypplication.class, args);
	}

}
