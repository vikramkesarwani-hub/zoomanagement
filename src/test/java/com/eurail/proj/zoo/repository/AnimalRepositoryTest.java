/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.eurail.proj.zoo.entiry.Animal;

/**
 * 
 * 
 * @author VK
 * 
 * 
 *         3 Nov 2020
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnimalRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AnimalRepository animalRepository;

	@Test
	public void testCreateAnimal() {
		// given 
		Animal aml = getAnimal("Monkey", "<=");
		Animal savedInDB = entityManager.persist(aml);
		// when
		Animal getFromDB = animalRepository.findById(savedInDB.getId()).get();
		// then
		assertThat(getFromDB).isEqualTo(savedInDB);

	}

	@Test
	public void testReadAnimal() { 
		Animal animal = getAnimal("Dog", "<=");
		Animal savedInDB = entityManager.persist(animal);
		Animal getAmlFromDB = animalRepository.getOne(savedInDB.getId());
		assertThat(savedInDB).isEqualTo(getAmlFromDB);

	}

	@Test
	public void testUpdateAnimal() {

		Animal animal = getAnimal("Horse", "<=");
		Animal savedInDB = entityManager.persist(animal);

		savedInDB.setTitle("Tiger");
		entityManager.persist(savedInDB);
		Animal getAmlFromDB = animalRepository.getOne(savedInDB.getId());
		assertThat(getAmlFromDB.getTitle()).isEqualTo("Tiger");

	}

	@Test 
	public void testDeleteAnimal() {

		Animal animalOne = getAnimal("Tiger", ">=");
		Animal animalTwo = getAnimal("Leo", ">=");

		Animal amlOne = entityManager.persist(animalOne);
		entityManager.persist(animalTwo);

		animalRepository.deleteById(amlOne.getId());

		Iterable<Animal> allAnimalFromDB = animalRepository.findAll();
		List<Animal> amlList = new ArrayList<Animal>();

		for (Animal e : allAnimalFromDB) {
			amlList.add(e);
		}
		assertThat(amlList.size()).isGreaterThan(1);
	}
	
	private long giveMeId() {
		return (long) Math.random();
	}

	private Animal getAnimal(String title, String type) {
		return (new Animal(giveMeId(), title, new Date(), 13, type));
	}

}
