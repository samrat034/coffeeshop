package edu.mum.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.mum.coffee")
public class CoffeShopApplication {
	
	private static Class applicationClass = CoffeShopApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(CoffeShopApplication.class, args);
	}
}