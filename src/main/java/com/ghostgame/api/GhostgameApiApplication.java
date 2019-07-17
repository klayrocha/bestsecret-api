package com.ghostgame.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ghostgame.api.service.DictionaryService;

/**
 * Class responsible for starting the application
 * @author Francis Klay Rocha
 *
 */
@SpringBootApplication
public class GhostgameApiApplication {
	
	@Autowired
	DictionaryService dictionaryService;

	public static void main(String[] args) {
		SpringApplication.run(GhostgameApiApplication.class, args);
	}

	/**
	 * It will load all the words in memory
	 */
	@Bean
	CommandLineRunner init() {
		return args -> {
			dictionaryService.loadWords();
		};
	}

}
