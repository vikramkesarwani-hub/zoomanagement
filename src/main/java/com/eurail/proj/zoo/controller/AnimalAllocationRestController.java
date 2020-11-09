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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eurail.proj.zoo.dto.AllocationDTO;
import com.eurail.proj.zoo.entiry.Favorite;
import com.eurail.proj.zoo.exception.DatabaseConstraintsException;
import com.eurail.proj.zoo.exception.ResourceNotFoundException;
import com.eurail.proj.zoo.service.IAnimalAllocationService;

/**
 * 
 * UseCase III - Animal allocation into room controller
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@RestController
public class AnimalAllocationRestController {

	/**
	 * logger 
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(AnimalAllocationRestController.class);

	@Autowired
	private IAnimalAllocationService amAllocationService;

	/**
	 * Place an animal into room
	 * @param allocationRequest
	 * @return Favorite
	 * @throws ResourceNotFoundException
	 */
	@PostMapping("/placeanimal")
	public ResponseEntity<Object> PlaceAnimal(
			@RequestBody @Valid AllocationDTO allocationRequest)
			throws ResourceNotFoundException {
		logger.info(
				"Inside Place Animal------------------------------------------------!!");
		if (allocationRequest != null && allocationRequest.getRoom_id() < 1
				&& allocationRequest.getAnimal_id() < 1) {
			throw new ResourceNotFoundException( 
					"Please provide Animal and Room Id !!");
		}
		Favorite fav; 
		try {
			fav = amAllocationService.PlaceAnimal(allocationRequest);
		} catch (DataIntegrityViolationException ex) {
			throw new DatabaseConstraintsException(
					"Exception thrown when an attempt to insert or update data!!");
		}
		return new ResponseEntity<Object>(fav, HttpStatus.OK);
	}

	/**
	 * Move an animal from one room to another room
	 * @param allocationRequest
	 * @return Favorite
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/moveanimal")
	public ResponseEntity<Object> MoveAnimal(
			@RequestBody @Valid AllocationDTO allocationRequest)
			throws ResourceNotFoundException {
		logger.info(
				"Inside MoveAnimal------------------------------------------------!!");
		if (allocationRequest != null && allocationRequest.getRoom_id() < 1
				&& allocationRequest.getAnimal_id() < 1) {
			throw new ResourceNotFoundException(
					"Please provide Animal and new Room Id!!");
		}
		Favorite fav;
		try {
			fav = amAllocationService.MoveAnimal(allocationRequest);
		} catch (DataIntegrityViolationException ex) {
			throw new DatabaseConstraintsException(
					"Exception thrown when an attempt to insert or update data!!");
		}
		return new ResponseEntity<Object>(fav, HttpStatus.OK);
	}

	/**
	 * Remove an animal from room
	 * @param allocationRequest
	 * @return Boolean
	 */
	@DeleteMapping("/removeanimal")
	public ResponseEntity<Object> RemoveAnimal(
			@RequestBody @Valid AllocationDTO allocationRequest) {
		logger.info(
				"Inside RemoveAnimal------------------------------------------------!!");
		if (allocationRequest != null && allocationRequest.getAnimal_id() < 1) {
			throw new ResourceNotFoundException("Please provide Animal Id!!");
		}
		return new ResponseEntity<Object>(
				amAllocationService.RemoveAnimal(allocationRequest),
				HttpStatus.OK);
	}
}
