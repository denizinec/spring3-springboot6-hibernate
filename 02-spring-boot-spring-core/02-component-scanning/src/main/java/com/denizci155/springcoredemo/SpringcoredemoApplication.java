package com.denizci155.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication(
		scanBasePackages = {"com.denizci155.springcoredemo",
							"com.denizci155.util"}
				)


 */
@SpringBootApplication
public class SpringcoredemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
