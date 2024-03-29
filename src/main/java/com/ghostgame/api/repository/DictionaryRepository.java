package com.ghostgame.api.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Class responsible for loading all words and returning list of them 
 * @author Francis Klay Rocha
 */
@Repository
public class DictionaryRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryRepository.class);
	private static List<String> words = new ArrayList<String>();
	
	 @Value("${file.words.path}")
	 private String fileWordsPath;

	/**
	 * Method responsible for returning all words
	 * @return words
	 */
	public List<String> getAllWords() {
		return words;
	}

	/**
	 * Method responsible for load all the words in memory
	 * @throws FileNotFoundException
	 */
	public void loadWords() throws FileNotFoundException {
		LOGGER.info("Starts load words");
		InputStream is = new FileInputStream(new File(fileWordsPath));
		Scanner sc = new Scanner(is);
		while (sc.hasNext()) {
			String word = sc.nextLine();
			if(word.length() > 3) {
				words.add(word.toLowerCase());
			}
		}
		sc.close();
		words.sort(Comparator.comparing(String::length));
		LOGGER.info("End load words ");
	}

}
