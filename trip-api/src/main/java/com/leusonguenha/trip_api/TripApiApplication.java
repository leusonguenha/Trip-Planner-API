package com.leusonguenha.trip_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class TripApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripApiApplication.class, args);
	}

}
