package com.ghostgame.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ghostgame.api.service.DictionaryService;

@SpringBootApplication
public class GhostgameApiApplication {
	
	@Autowired
	DictionaryService dictionaryService;

	public static void main(String[] args) {
		SpringApplication.run(GhostgameApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			dictionaryService.loadWords();
		};
	}

}
