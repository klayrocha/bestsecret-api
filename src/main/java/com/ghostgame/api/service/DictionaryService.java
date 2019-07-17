package com.ghostgame.api.service;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;

import com.ghostgame.api.response.Word;

/**
 * Service interface for business rules
 * 
 * @author Francis Klay Rocha
 *
 */
@Component
public interface DictionaryService {

	/**
	 * Method responsible for load all the words in memory
	 * 
	 * @throws FileNotFoundException
	 */
	public void loadWords() throws FileNotFoundException;

	/**
	 * Method responsible to find the better word
	 * 
	 * @param letter
	 * @param lettersInserted
	 * @return Word
	 */
	public Word findWord(String letter, String lettersInserted);

}
