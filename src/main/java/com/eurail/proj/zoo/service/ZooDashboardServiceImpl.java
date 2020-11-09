/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurail.proj.zoo.dto.AnimalReportDTO;
import com.eurail.proj.zoo.dto.HappyAnimalDTO;
import com.eurail.proj.zoo.entiry.Animal;
import com.eurail.proj.zoo.entiry.Room;
import com.eurail.proj.zoo.repository.AnimalRepository;
import com.eurail.proj.zoo.repository.RoomRepository;

/**
 * 
 * 
 * @author VK
 * 
 * 
 *         1 Nov 2020
 */
@Service
public class ZooDashboardServiceImpl implements IZooDashboardService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ZooDashboardServiceImpl.class);

	@Autowired
	private AnimalRepository amRepository;

	@Autowired
	private RoomRepository rmRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zooMgt.service.ZooDashboardService#getZooAnimals()
	 */
	@Override
	public List<AnimalReportDTO> getZooAnimals(String sortingKey,
			String sortingOrder) {
		if (sortingKey == null)
			sortingKey = "title";
		if (sortingOrder != null)
			sortingOrder = "desc";
		return amRepository.getZooAnimals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zooMgt.service.ZooDashboardService#getRoomAnimals(long)
	 */
	@Override
	public List<AnimalReportDTO> getRoomAnimals(long roomId) {
		return amRepository.getRoomAnimals(roomId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zooMgt.service.ZooDashboardService#getAnimalFavoriteRoom(
	 * long)
	 */
	@Override
	public List<String> getAnimalFavoriteRoom(long animalId) {
		List<String> roomTitles = new ArrayList<String>();
		List<Room> listRoom = new ArrayList<Room>();
		
		if (amRepository.findById(animalId).isPresent()) {
			Animal am = amRepository.findById(animalId).get();
			
			// decide favorite based on preference and type
			if (am.getType().equals("<=")) {
				listRoom = rmRepository
						.findBySizeLessThanEqual(am.getPreference());
			}
			if (am.getType().equals(">=")) {
				listRoom = rmRepository
						.findBySizeGreaterThanEqual(am.getPreference());
			}
		}
		// Fetch all titles
		roomTitles = listRoom.stream().map(room -> room.getTitle())
				.collect(Collectors.toList());
		return roomTitles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zooMgt.service.ZooDashboardService#getHappyAnimalsPerRoom
	 * ()
	 */
	@Override
	public List<HappyAnimalDTO> getHappyAnimalsPerRoom() {
		logger.info("Happy Animals----------------->");
		return rmRepository.getHappyAnimals();
	}

}
