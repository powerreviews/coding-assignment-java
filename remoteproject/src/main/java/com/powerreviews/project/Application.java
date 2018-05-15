package com.powerreviews.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			//implement a POJO representation and replace Object
			TypeReference<List<Object>> typeReference = new TypeReference<List<Object>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/restaurants.json");
			try {
				List<Object> restaurants = mapper.readValue(inputStream, typeReference);
				//save restaurants to the database
			} catch (IOException e){
				System.out.println("Unable to save restaurants: " + e.getMessage());
			}
		};
	}
}
