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
		List<String> words = dictionaryRepository.getAllWords();
		String wordTest;
		if(lettersInserted.equals("empty_letter")) {
			 wordTest = letter;
		} else {
			 wordTest = lettersInserted.concat(letter.toLowerCase());
		}
		Word word = new Word();
		word.setLettersInserted(wordTest);
		if(words.contains(wordTest)) {
			word.setPlayerWin(true);
			return word;
		}
		LOGGER.info("end find words");
		return word;
	}

}
