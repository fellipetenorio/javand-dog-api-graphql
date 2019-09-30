package com.tenorio.javand.dogapi.dogapigraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DogapigraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogapigraphqlApplication.class, args);
	}

}
