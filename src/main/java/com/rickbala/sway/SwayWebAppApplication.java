package com.rickbala.sway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwayWebAppApplication {

	@Value("#{spring.data.mongodb.uri}")
	private static String connectionUri;

	public static void main(String[] args) {
		SpringApplication.run(SwayWebAppApplication.class, args);
	}

}
