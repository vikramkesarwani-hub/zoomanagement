/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.eurail.proj.zoo.dto.AnimalDTO;
import com.eurail.proj.zoo.entiry.Animal;
import com.eurail.proj.zoo.service.IAnimalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Animal Entity CRUD operation test controller  
 * @author VK
 * 
 * 
 *         3 Nov 2020
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = AnimalRestController.class)
public class AnimalControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IAnimalService animalService;

	@Test
	public void testCreateAnimal() throws Exception {
		//given
		Animal aml = new Animal(1, "Tiger", new Date(), 13, "<=");
		String URI = "/v1.0/animal/1";
		//when 
		Mockito.when(animalService.read(Mockito.anyLong())).thenReturn(aml);
		//then
		String expectedJson = this.mapToJson(aml);
		mockMvc.perform(get(URI)).andExpect(status().isFound())
				.andExpect(content().json(expectedJson));

	}
	
	@Test
	public void testSaveAnimal() throws Exception {

		Animal aml = new Animal(1, "Tiger", new Date(), 13, "<=");

		String inputInJson = this.mapToJson(aml);
		String URI = "/v1.0/animal";
		Mockito.when(animalService.create(Mockito.any(AnimalDTO.class))).thenReturn(aml);


		//then
		mockMvc.perform(post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(inputInJson).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(inputInJson));
		
	}
	
	@Test
	public void testUpdateAnimal() throws Exception {

		//given
		Animal aml = new Animal(1, "Tiger", new Date(), 13, "<=");
		AnimalDTO amlDTO = new AnimalDTO("Tiger", new Date(), 13, "<=");

		String URI = "/v1.0/animal/1";
		String inputJson = this.mapToJson(amlDTO);
		aml.setTitle("Dog");
		String expectedJson = this.mapToJson(aml);
		
		//when
		Mockito.when(animalService.update(Mockito.anyLong(),
				Mockito.any(AnimalDTO.class))).thenReturn(aml);
		
		//then
		mockMvc.perform(put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(inputJson).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(expectedJson));

	}

	@Test
	public void testDeleteAnimal() throws Exception {
		//Animal aml = new Animal(1, "Tiger", new Date(), 13, "<=");
		String URI = "/v1.0/animal/1";
		mockMvc.perform(delete(URI)).andExpect(status().isNoContent());

	}

	private String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);

	}
}
