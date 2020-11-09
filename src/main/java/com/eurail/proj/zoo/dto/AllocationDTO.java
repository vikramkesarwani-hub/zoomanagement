/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Data transfer object for allocation of room and animals
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@Getter
@Setter
@Data
public class AllocationDTO {

	@NotNull(message = "Animal Id can't be null!!")
	private long animal_id;

	private long room_id;

	/**
	 * @return the room_id
	 */
	public long getRoom_id() {
		return room_id;
	}

	/**
	 * @param room_id
	 *            the room_id to set
	 */
	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	/**
	 * @return the animal_id
	 */
	public long getAnimal_id() {
		return animal_id;
	}

	/**
	 * @param animal_id
	 *            the animal_id to set
	 */
	public void setAnimal_id(long animal_id) {
		this.animal_id = animal_id;
	}

}
