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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eurail.proj.zoo.dto.SortingDTO;
import com.eurail.proj.zoo.service.IZooDashboardService;

/**
 * 
 * Use Case V - Dashboard of zoo 
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@RestController
public class ZooDashboardRestController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ZooDashboardRestController.class);

	@Autowired 
	IZooDashboardService zooDashboardService;

	/**
	 * List of animals in the zoo but not in the room
	 * @param sortingRequest
	 * @return List of AnimalReportDTO
	 */
	@PostMapping("/animals")
	public ResponseEntity<Object> getRoomLessZooAnimals(
			@RequestBody @Valid SortingDTO sortingRequest) {
		logger.info("Zoo Animals----------------------------------------->");
		return new ResponseEntity<Object>(zooDashboardService.getZooAnimals(
				sortingRequest.getSortingKey(),
				sortingRequest.getSortingOrder()), HttpStatus.OK);
	}

	/**
	 * List of animals in the specific room
	 * 
	 * @param roomId
	 * @return List of AnimalReportDTO
	 */
	@GetMapping("/animals/{roomId}")
	public ResponseEntity<Object> getAnimalsInRoom(
			@PathVariable("roomId") long roomId) {
		logger.info("Room Animals----------------------------------------->");
		return new ResponseEntity<Object>(
				zooDashboardService.getRoomAnimals(roomId), HttpStatus.OK);
	}

	/**
	 * List of favorite rooms for specific animal
	 * 
	 * @param animalId
	 * @return List of String
	 */
	@GetMapping("/animal/{animalId}/rooms")
	public ResponseEntity<Object> getAnimalFavoriteRoom(
			@PathVariable("animalId") long animalId) {
		logger.info(
				"Favorite Animals----------------------------------------->");
		return new ResponseEntity<Object>(
				zooDashboardService.getAnimalFavoriteRoom(animalId),
				HttpStatus.OK);
	}

	/**
	 * Result for happy animals.If animal is not happy, this room cannot be
	 * favorite. -Each room has a size. -Each animal has preference for size of
	 * the room (two additional fields: greaterthanequals or lessthanequals and room size)
	 * 
	 * @return List of HappyAnimalDTO
	 */
	@PostMapping("/rooms/animals")
	public ResponseEntity<Object> getHappyAnimalsPerRoom() {
		logger.info("Happy Animals----------------------------------------->");
		return new ResponseEntity<Object>(
				zooDashboardService.getHappyAnimalsPerRoom(), HttpStatus.OK);
	}

}
