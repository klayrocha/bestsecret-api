package com.ghostgame.api.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.ghostgame.api.GhostgameApiApplicationTests;
import com.ghostgame.api.exception.DictionaryException;
import com.ghostgame.api.response.Word;
import com.ghostgame.api.service.DictionaryService;

public class DictionaryServiceImplTest extends GhostgameApiApplicationTests {
	
	@Autowired
	DictionaryService dictionaryService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void findWord() {
		assertNotNull(dictionaryService.findWord("a","ab"));
	}
	
	@Test
	public void findWordPlayerLost() {
		Word word = dictionaryService.findWord("a","axx");
		assertFalse(word.isPlayerWin());
	}
	
	@Test
	public void findWordComputerLost() {
		Word word = dictionaryService.findWord("r","cavita");
		assertFalse(word.isComputerWin());
	}
	
	@Test
	public void findWordTwoLetters() {
		exception.expect(DictionaryException.class);
		exception.expectMessage("Only one letter is allowed");
		dictionaryService.findWord("aa","ab");
	}
	
	@Test
	public void findWordValueInputNumeric() {
		exception.expect(DictionaryException.class);
		exception.expectMessage("No numeric values allowed");
		dictionaryService.findWord("1","ab");
	}

}
