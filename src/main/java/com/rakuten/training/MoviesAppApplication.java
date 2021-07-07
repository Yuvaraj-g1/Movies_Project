package com.rakuten.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MoviesAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = SpringApplication.run(MoviesAppApplication.class, args);

	}

}
