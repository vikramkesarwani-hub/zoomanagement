/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import com.eurail.proj.zoo.dto.RoomDTO;
import com.eurail.proj.zoo.entiry.Room;

/**
 * 
 * Service layer for Room Entity CRUD operation
 * @author VK
 * 
 * 
 * 2 Nov 2020
 */
public interface IRoomService {

	
	/**
	 * 
	 * @param roomDTO
	 * @return
	 */
	public Room create(RoomDTO roomDTO);

	/**
	 * 
	 * @param room_Id
	 * @return
	 */
	public Room read(long room_Id);

	/**
	 * 
	 * @param animal_Id
	 * @param roomDTO
	 * @return
	 */
	public Room update(long room_Id, RoomDTO roomDTO);

	/**
	 * 
	 * @param room_Id
	 * @return
	 */
	public boolean delete(long room_Id);
}
