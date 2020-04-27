package com.satish.msproducts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(getApiInfo())
					.select()
					.apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.any())
					.build();
		
	}
	
	//Swagger Metadata: http://localhost:8080/v2/api-docs
		//Swagger UI URL: http://localhost:8080/swagger-ui.html 
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("SpringBoot User Admin Roles Service")
				.description("This page lists all API's of User Roles")
				.version("2.0")
				.contact(new Contact("Satish Prasad", "https://www.satish.com", "spd61185@gmail.com"))
				.license("License 2.0")
				.licenseUrl("https://www.satish.com/license.html")
				.build();
	}
}
