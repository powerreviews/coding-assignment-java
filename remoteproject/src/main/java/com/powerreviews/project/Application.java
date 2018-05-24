package com.powerreviews.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerreviews.project.restaurant.RestaurantEntity;
import com.powerreviews.project.restaurant.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(RestaurantRepository repository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			//implement a POJO representation and replace Object
			TypeReference<List<RestaurantEntity>> typeReference = new TypeReference<List<RestaurantEntity>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/restaurants.json");
			try {
				List<RestaurantEntity> restaurants = mapper.readValue(inputStream, typeReference);
				//save restaurants to the database
				repository.saveAll(restaurants);
			} catch (IOException e){
				//TODO Establish a standard and use a logging framework
				System.out.println("Unable to save restaurants: " + e.getMessage());
			}
		};
	}
}
