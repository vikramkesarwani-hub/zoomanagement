/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eurail.proj.zoo.dto.AnimalDTO;
import com.eurail.proj.zoo.entiry.Animal;
import com.eurail.proj.zoo.exception.ResourceNotFoundException;
import com.eurail.proj.zoo.service.IAnimalService;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Use Case I - Animal Entity CRUD controller class
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@RestController
public class AnimalRestController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(AnimalRestController.class);

	@Autowired 
	private IAnimalService animalService;

	/**
	 * Animal Entity Create operation
	 * @param animalRequest
	 * @return Animal
	 */
	@PostMapping("/v1.0/animal")
	@ApiModelProperty(
		    value = "The fields marked with an * means that they are required.",
		    example = "{Title: Tiger, located: 2020-11-06 12:10:11, preference: 13, Type: <=}")
	public ResponseEntity<Animal> Create(
			@RequestBody @Valid AnimalDTO animalRequest) {
		logger.info( 
				"Inside create------------------------------------------------!!");
		return new ResponseEntity<>(animalService.create(animalRequest),
				HttpStatus.CREATED);
	}

	/**
	 * Animal Entity Read operation
	 * @param animal_Id
	 * @return Animal
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/v1.0/animal/{id}")
	public ResponseEntity<Animal> Read(@PathVariable("id") long animal_Id)
			throws ResourceNotFoundException {
		logger.info(
				"Inside reads------------------------------------------------!!");
		return new ResponseEntity<>(animalService.read(animal_Id),
				HttpStatus.FOUND);
	}

	/**
	 * Animal Entity Update operation
	 * @param animal_Id
	 * @param animalRequest
	 * @return Animal
	 */
	@RequestMapping(value = "/v1.0/animal/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
	public ResponseEntity<Animal> Update(@PathVariable("id") long animal_Id,
			@RequestBody @Valid AnimalDTO animalRequest) {
		logger.info(
				"Inside update------------------------------------------------!!");
		return new ResponseEntity<>(
				animalService.update(animal_Id, animalRequest), HttpStatus.OK);
	}

	/**
	 * Animal Entity Delete operation
	 * @param animal_Id
	 * @return Boolean
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/v1.0/animal/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long animal_Id)
			throws ResourceNotFoundException {
		logger.info(
				"Inside delete------------------------------------------------!!");
		return new ResponseEntity<Object>(animalService.delete(animal_Id),
				HttpStatus.NO_CONTENT);
	}

}
