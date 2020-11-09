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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eurail.proj.zoo.dto.AllocationDTO;
import com.eurail.proj.zoo.exception.ResourceNotFoundException;
import com.eurail.proj.zoo.service.IRoomAllocationService;

/**
 * 
 * Use Case IV - Assign/Unassign room to animal as favorite
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@RestController
public class RoomAllocationRestController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(RoomAllocationRestController.class);
 
	@Autowired
	IRoomAllocationService rmAllocationService;

	/**
	 * Assign room to animal as favorite
	 * @param allocationRequest
	 * @return Favorite
	 */
	@PostMapping("/assignroom")
	public ResponseEntity<Object> AssignRoom(
			@RequestBody @Valid AllocationDTO allocationRequest) {
		logger.info(
				"Inside Assign Room------------------------------------------------!!");
		if (allocationRequest != null && allocationRequest.getAnimal_id() < 1) {
			throw new ResourceNotFoundException(
					"Please provide Animal Id!!");
		}
		return new ResponseEntity<Object>(rmAllocationService
				.AssignRoom(allocationRequest.getAnimal_id()), HttpStatus.OK);
	}

	/**
	 * UnAssign room to animal as favorite
	 * @param allocationRequest
	 * @return String
	 */
	@DeleteMapping("/unassignroom")
	public ResponseEntity<Object> UnassignRoom(
			@RequestBody @Valid AllocationDTO allocationRequest) {
		logger.info(
				"Inside UnAssign Room------------------------------------------------!!");
		if (allocationRequest != null && allocationRequest.getAnimal_id() < 1) {
			throw new ResourceNotFoundException(
					"Please provide Animal Id!!");
		}
		return new ResponseEntity<Object>(
				"{\"Message\": " + "\""
						+ rmAllocationService.UnassignRoom(
								allocationRequest.getAnimal_id())
						+ "\"}",
				HttpStatus.OK);
	}
}
