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
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner initRestaurants(RestaurantRepository repository) {
		return args -> {
			importJson(
					"/json/restaurants.json",
					repository,
					new TypeReference<List<RestaurantEntity>>() {}
			);
		};
	}

	@Bean
	CommandLineRunner initUsers(UserRepository repository) {
		return args -> {
			importJson(
					"/json/users.json",
					repository,
					new TypeReference<List<UserEntity>>() {}
			);
		};
	}

	private static <T> void importJson(String filename, CrudRepository<T, ?> repository,
			TypeReference<List<T>> typeReference) {
		// read json and write to db
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = TypeReference.class.getResourceAsStream(filename);
		try {
			List<T> entities = mapper.readValue(inputStream, typeReference);
			//save to database
			repository.saveAll(entities);
		} catch (IOException e){
			//TODO Establish a standard and use a logging framework
			System.out.println("Unable to save: " + e.getMessage());
		}
	}
}
