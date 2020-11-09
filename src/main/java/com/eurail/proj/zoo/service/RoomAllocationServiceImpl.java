/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurail.proj.zoo.entiry.Animal;
import com.eurail.proj.zoo.entiry.Favorite;
import com.eurail.proj.zoo.entiry.Room;
import com.eurail.proj.zoo.exception.ResourceNotFoundException;
import com.eurail.proj.zoo.repository.AnimalRepository;
import com.eurail.proj.zoo.repository.FavoriteRepository;
import com.eurail.proj.zoo.repository.RoomRepository;

/**
 * 
 * Interface implementation for assign/unassign room use case IV
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@Service
public class RoomAllocationServiceImpl implements IRoomAllocationService {

	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(RoomAllocationServiceImpl.class);
	
	@Autowired
	private FavoriteRepository favRepository;

	@Autowired
	private AnimalRepository amRepository;

	@Autowired
	private RoomRepository rmRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zooMgt.service.RoomAllocationService#AssignRoom(long)
	 */
	@Override
	public Favorite AssignRoom(long id) {
		
		logger.info("Inside assignRoom------------------->");
		//find animal first
		List<Room> listRoom = new ArrayList<Room>();
		if(amRepository.findById(id).isPresent()) {
			
			Animal am = amRepository.findById(id).get();
			//decide favorite based on preference and type 
			logger.info("Inside assignRoom------------------->"+am.getType());
			if (am.getType().equals("<=")) {

				listRoom = rmRepository.findBySizeLessThanEqual(am.getPreference());
			}
			if (am.getType().equals(">=")) {

				listRoom = rmRepository
						.findBySizeGreaterThanEqual(am.getPreference());
			}
		}
			
		//delete from room if any 
		favRepository.deleteByAnimal_id(id);

		//assign favorite room- enjoy 
		Favorite fav = new Favorite();
		if (listRoom.size() > 0) {
			long room_id = listRoom.get(0).getId();
			fav.setAnimal_id(id);
			fav.setRoom_id(room_id);
			favRepository.save(fav);
		}

		return fav;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zooMgt.service.RoomAllocationService#UnassignRoom(long)
	 */
	@Override
	public String UnassignRoom(long id) throws ResourceNotFoundException {

		logger.info("Inside UnassignRoom------------------->");
		//Real life Assumption -  an animal can only be assign to only one room and physically present at one room only
		String msg = "Animal not in favorite room!!";
		//find animal record
		List<Room> listRoom = new ArrayList<Room>();
		if(amRepository.findById(id).isPresent()) {
			Animal am = amRepository.findById(id).get();
			//find favorite based on preference and type 
			
			if (am.getType().equals("<=")) {

				listRoom = rmRepository.findBySizeLessThanEqual(am.getPreference());
			}
			if (am.getType().equals(">=")) {

				listRoom = rmRepository
						.findBySizeGreaterThanEqual(am.getPreference());
			}	
			//if animal in room
			if(favRepository.findByAnimal_id(id) != null) {
				long room_id = favRepository.findByAnimal_id(id).getRoom_id();
				//iterate and delete from favorite room
				listRoom.forEach(room -> {
					if (room.getId() == room_id) {
						favRepository.deleteByAnimal_id(id);
					}
				});		
				if(favRepository.findByAnimal_id(id) == null) {
					msg = "Record found and deleted successfully!!";
				}
			}else {
				msg = "Animal is not assign to any room!!";
			}
	
		} else{
			 msg = "No Animal found!!";
		}



		return msg;
	}

}
