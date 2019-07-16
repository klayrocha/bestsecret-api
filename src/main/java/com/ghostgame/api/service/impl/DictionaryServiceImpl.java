package com.ghostgame.api.service.impl;

import java.io.FileNotFoundException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghostgame.api.repository.DictionaryRepository;
import com.ghostgame.api.response.Word;
import com.ghostgame.api.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);
	
	@Autowired
	DictionaryRepository dictionaryRepository;

	@Override
	public void loadWords() throws FileNotFoundException {
		dictionaryRepository.loadWords();
	}
	
	public Word findWord(String letter, String lettersInserted) {
		LOGGER.info("Starts find words");
		Word word = new Word();
		List<String> words = dictionaryRepository.getAllWords();
		String wordTest;
		if(lettersInserted.equals("empty_letter")) {
			 wordTest = letter.toLowerCase();
		} else {
			 wordTest = lettersInserted.concat(letter.toLowerCase());
		}
		
		if(wordTest.length() >= 3) {
			boolean exist = false;
			for (String w : words) {
				if(w.startsWith(wordTest)) {
					exist = true;
				}
			}
			if(!exist) {
				word.setLettersInserted(wordTest);
				word.setPlayerWin(false);
				word.setComputerWin(true);
				LOGGER.info("Player lost");
				return word;
			}
		}
		
		if(words.contains(wordTest)) {
			word.setLettersInserted(wordTest);
			word.setPlayerWin(false);
			word.setComputerWin(true);
			LOGGER.info("Player lost");
			return word;
		} else {
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
}