/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurail.proj.zoo.dto.RoomDTO;
import com.eurail.proj.zoo.entiry.Room;
import com.eurail.proj.zoo.exception.ResourceNotFoundException;
import com.eurail.proj.zoo.repository.RoomRepository;

/**
 * 
 * 
 * @author DiviHome
 * 
 * 
 *         2 Nov 2020
 */
@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomRepository roomRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zoo.service.RoomService#create(com.eurail.proj.zoo.dto.
	 * RoomDTO)
	 */
	@Override
	public Room create(RoomDTO roomDTO) {

		ModelMapper modelMapper = new ModelMapper();
		Room room = modelMapper.map(roomDTO, Room.class);
		return roomRepository.save(room);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zoo.service.RoomService#read(long)
	 */
	@Override
	public Room read(long room_Id) {

		Room rm = roomRepository.findById(room_Id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Room not found with id " + room_Id));
		return rm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zoo.service.RoomService#update(long,
	 * com.eurail.proj.zoo.dto.RoomDTO)
	 */
	@Override
	public Room update(long room_Id, RoomDTO roomDTO) {

		Room rom = roomRepository.findById(room_Id).map(room -> {
			room.setTitle(roomDTO.getTitle());
			room.setCreated(roomDTO.getCreated());
			room.setSize(roomDTO.getSize());
			return roomRepository.save(room);
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Room not found with id " + room_Id));
		return rom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zoo.service.RoomService#delete(long)
	 */
	@Override
	public boolean delete(long room_Id) {

		roomRepository.findById(room_Id).map(room -> {
			roomRepository.delete(room);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Room not found with id " + room_Id));
		return true;
	}

}
