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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eurail.proj.zoo.dto.RoomDTO;
import com.eurail.proj.zoo.exception.ResourceNotFoundException;
import com.eurail.proj.zoo.service.IRoomService;

/**
 * 
 * Use Case II - Room Entity CRUD controller class
 * 
 * @author DiviHome
 * 
 * 
 *         01 Nov 2020
 */
@RestController
public class RoomRestController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(RoomRestController.class);
 
	/**
	 * 
	 */
	@Autowired
	private IRoomService roomService;

	/**
	 * Create record using Room entity
	 * @param roomRequest
	 * @return Room
	 */
	@PostMapping("/v1.0/room")
	public ResponseEntity<Object> Create(
			@RequestBody @Valid RoomDTO roomRequest) {
		logger.info(
				"Inside create------------------------------------------------!!");
		return new ResponseEntity<Object>(roomService.create(roomRequest),
				HttpStatus.CREATED);
	}

	/**
	 * Read record using Room entity
	 * @param room_Id
	 * @return Room
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/v1.0/room/{id}")
	public ResponseEntity<Object> Read(@PathVariable("id") long room_Id)
			throws ResourceNotFoundException {
		logger.info(
				"Inside reads------------------------------------------------!!");
		return new ResponseEntity<Object>(roomService.read(room_Id),
				HttpStatus.FOUND);
	}

	/**
	 * Update record using Room entity
	 * @param room_Id
	 * @param roomRequest
	 * @return Room
	 */
	@PutMapping("/v1.0/room/{id}")
	public ResponseEntity<Object> Update(@PathVariable("id") long room_Id,
			@RequestBody @Valid RoomDTO roomRequest) {
		logger.info(
				"Inside update------------------------------------------------!!");
		return new ResponseEntity<Object>(
				roomService.update(room_Id, roomRequest), HttpStatus.OK);
	}

	/**
	 * Delete record using Room entity
	 * @param room_Id
	 * @return boolean
	 */
	@DeleteMapping("/v1.0/room/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long room_Id) {
		logger.info(
				"Inside delete------------------------------------------------!!");
		return new ResponseEntity<Object>(roomService.delete(room_Id),
				HttpStatus.NO_CONTENT);
	}
}
