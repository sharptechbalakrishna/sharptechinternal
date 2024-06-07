package com.sharp;
/**
 * @author Sharptech-21
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SharptechinternalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharptechinternalApplication.class, args);
	}

}