package com.ghostgame.api.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ghostgame.api.GhostgameApiApplicationTests;

public class DictionaryRepositoryTest extends GhostgameApiApplicationTests {
	
	@Autowired
	DictionaryRepository dictionaryRepository;
	
	@Test
	public void findWord() {
		assertNotNull(dictionaryRepository.getAllWords());
	}
}
