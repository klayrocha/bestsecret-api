package com.ghostgame.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghostgame.api.response.Response;
import com.ghostgame.api.response.Word;
import com.ghostgame.api.service.DictionaryService;

/**
 * Class RESTful for DictionaryController
 * 
 * @author Francis Klay Rocha
 *
 */

@RestController
@RequestMapping("/api/ghostGame")
@CrossOrigin(origins = "*")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * EndPoint responsible to find the better word
	 * @param letter
	 * @param lettersInserted
	 * @return ResponseEntity<Response<Word>>
	 * @throws IsNumberException 
	 */
	@GetMapping(value = "{letter}/{lettersInserted}")
	public ResponseEntity<Response<Word>> findWord(@PathVariable String letter,	@PathVariable String lettersInserted) {
		Response<Word> response = new Response<Word>();
		Word word = dictionaryService.findWord(letter, lettersInserted);
		response.setData(word);
		return ResponseEntity.ok(response);
	}
}
