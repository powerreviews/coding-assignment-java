package com.powerreviews.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerreviews.project.persistence.RestaurantEntity;
import com.powerreviews.project.persistence.RestaurantRepository;
import com.powerreviews.project.persistence.UserEntity;
import com.powerreviews.project.persistence.UserRepository;
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
	CommandLineRunner runner(RestaurantRepository restaurantRepository, UserRepository userRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();

			TypeReference<List<RestaurantEntity>> restaurantTypeReference = new TypeReference<List<RestaurantEntity>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/restaurants.json");
			try {
				List<RestaurantEntity> restaurants = mapper.readValue(inputStream, restaurantTypeReference);
				//save restaurants to the database
				restaurantRepository.saveAll(restaurants);
			} catch (IOException e){
				System.out.println("Unable to save restaurants: " + e.getMessage());
			}

			TypeReference<List<UserEntity>> userTypeReference = new TypeReference<List<UserEntity>>(){};
			inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<UserEntity> users = mapper.readValue(inputStream, userTypeReference);
				//save users to the database
				userRepository.saveAll(users);
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
