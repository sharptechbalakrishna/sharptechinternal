package com.sharp.webconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;

@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {

		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000") // Adjust to your frontend origin
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedOrigins("*");
			}
		};

	}

}
