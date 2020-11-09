/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.eurail.proj.zoo.entiry.Animal;
import com.eurail.proj.zoo.repository.AnimalRepository;

/**
 * 
 * 
 * @author VK
 * 
 * 
 *         3 Nov 2020
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IAnimalServiceTest {

	@Autowired
	private IAnimalService animalService;

	@MockBean
	private AnimalRepository animalRepository;

	@Test
	public void testReadAnimal() {
		// given
		Animal amlSave = getAnimal("Tiger", ">=");

		Optional<Animal> oAml = Optional.of(amlSave);
		// when
		Mockito.when(animalRepository.findById(1L)).thenReturn(oAml);
		// then
		assertThat(animalService.read(1L)).isEqualTo(oAml.get());

	}

	@Test
	public void testUpdateAnimal() {
		Animal aml = getAnimal("Tiger", ">=");

		Optional<Animal> oAml = Optional.of(aml);
		Mockito.when(animalRepository.findById(1L)).thenReturn(oAml);

		oAml.get().setTitle("Leo");

		Mockito.when(animalRepository.findById(1L)).thenReturn(oAml);

		assertThat(animalService.read(1L).getTitle()).isEqualTo("Leo");

	}

	@Test
	public void testDeleteAnimal() {
		Animal aml = getAnimal("Tiger", ">=");

		Mockito.when(animalRepository.findById(1L))
				.thenReturn(Optional.of(aml));
		Mockito.when(animalRepository.existsById(aml.getId()))
				.thenReturn(false);

		assertFalse(animalRepository.existsById(aml.getId()));
	}

	private long giveMeId() {
		return (long) Math.random();
	}

	private Animal getAnimal(String title, String type) {
		return (new Animal(giveMeId(), title, new Date(), 13, type));
	}
}
