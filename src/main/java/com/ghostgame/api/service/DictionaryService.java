package com.ghostgame.api.service;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;

import com.ghostgame.api.response.Word;

@Component
public interface DictionaryService {

	public void loadWords() throws FileNotFoundException;

	public Word findWord(String letter, String lettersInserted);

}
