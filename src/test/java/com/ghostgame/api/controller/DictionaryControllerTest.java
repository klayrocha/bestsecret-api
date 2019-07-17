package com.ghostgame.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghostgame.api.GhostgameApiApplicationTests;
import com.ghostgame.api.response.Response;

public class DictionaryControllerTest extends GhostgameApiApplicationTests {
	
	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void findWord() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/ghostGame/a/ab").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void findWordPlayerLost() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/ghostGame/a/axx").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		ObjectMapper objectMapper = new ObjectMapper();
		
		Response response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Response.class);
		LinkedHashMap lhm = (LinkedHashMap) response.getData();
		boolean playerWin = (boolean) lhm.get("playerWin");
		assertFalse(playerWin);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void findWordComputerLost() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/ghostGame/r/cavita").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		ObjectMapper objectMapper = new ObjectMapper();
		
		Response response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Response.class);
		LinkedHashMap lhm = (LinkedHashMap) response.getData();
		boolean computerWin = (boolean) lhm.get("computerWin");
		assertFalse(computerWin);
	}
	
	@Test
	public void findWordTwoLetters() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/ghostGame/aa/ab").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(417, status);
	}
	
	@Test
	public void findWordValueInputNumeric() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/ghostGame/1/ab").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(417, status);
	}
}