package com.sharp;
/**
 * @author Sharptech-21
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class SharptechinternalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharptechinternalApplication.class, args);
	}

}
// Checking for Id test