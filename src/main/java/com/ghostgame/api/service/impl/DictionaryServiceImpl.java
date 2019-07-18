package com.ghostgame.api.service.impl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghostgame.api.exception.DictionaryException;
import com.ghostgame.api.repository.DictionaryRepository;
import com.ghostgame.api.response.Word;
import com.ghostgame.api.service.DictionaryService;

/**
 * Service class for business rules
 * 
 * @author Francis Klay Rocha
 *
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);
	private static final String EMPTY_LETTER_FIRST_TIME =  "empty_letter";
	
	@Autowired
	DictionaryRepository dictionaryRepository;

	/**
	 * Method responsible for load all the words in memory
	 * 
	 * @throws FileNotFoundException
	 */
	@Override
	public void loadWords() throws FileNotFoundException {
		dictionaryRepository.loadWords();
	}
	
	
	/**
	 * Method responsible to find the better word
	 * @param letter
	 * @param lettersInserted
	 * @return Word
	 * @throws IsNumberException 
	 */
	public Word findWord(String letter, String lettersInserted) {
		LOGGER.info("Starts find words");
		validLetter(letter);
		Word word = new Word();
		List<String> words = dictionaryRepository.getAllWords();
		String wordTest;
		// First time, to be a valid endpoint,needed to add a text
		if(lettersInserted.equals(EMPTY_LETTER_FIRST_TIME)) {
			 wordTest = letter.toLowerCase();
		} else {
			 wordTest = lettersInserted.concat(letter.toLowerCase());
		}
		
		// I check if there is a word that begins with the letter, can be '
		boolean exist = false;
		for (String w : words) {
			if(w.startsWith(wordTest)) {
				exist = true;
				break;
			}
		}
		if(!exist) {
			word.setLettersInserted(wordTest);
			word.setPlayerWin(false);
			word.setComputerWin(true);
			LOGGER.info("Player lost");
			return word;
		}
		
		
		// Here I check if the player has already completed a word
		if(words.contains(wordTest)) {
			word.setLettersInserted(wordTest);
			word.setPlayerWin(false);
			word.setComputerWin(true);
			LOGGER.info("Player lost");
			return word;
		} else {
			//Here I check the next letter to add in the word, if it doesn't have, the player wins 
			String newWord = "";
			for (String w : words) {
				if(w.startsWith(wordTest)) {
					newWord = wordTest + w.substring(wordTest.length(),wordTest.length()+1);
					if(newWord.equals(w)) {
						newWord = "";
						continue;
					} else {
						if(words.contains(newWord)) {
							newWord = "";
							continue;
						}
						word.setLettersInserted(newWord);
						return word;
					}
				}
				word.setLettersInserted(wordTest);
			}
			word.setPlayerWin(true);
			word.setComputerWin(false);
		}
		LOGGER.info("end find words");
		return word;
	}
	
	
	/**
	 * Method responsible for validate the letter
	 * @param value
	 * @return boolean
	 */
	public static void validLetter(String value) {
		if(Pattern.matches("\\d+",value)) {
			throw new DictionaryException("No numeric values allowed");
		}
		if(value.length() > 1) {
			throw new DictionaryException("Only one letter is allowed");
		}
		LOGGER.info("Validated letter");
	}
}