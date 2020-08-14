package com.satish;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class RestWebConfig extends WebMvcConfigurationSupport {
	@Override
	protected void extendMessageConverters( List<HttpMessageConverter<?>> converters ) {
		for ( HttpMessageConverter<?> converter : converters ) {
			System.out.println(converter.getClass().getName());
		} 
	}
}