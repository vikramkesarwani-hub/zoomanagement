/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Data transfer object for showing happy animal.
 * @author VK
 * 
 * 
 *         1 Nov 2020
 */
@Getter
@Setter
@Data
public class HappyAnimalDTO {

	private String roomTitle;

	private long numberOfHappyAnimal;

	public HappyAnimalDTO() {
	}

	public HappyAnimalDTO(String roomTitle, long numberOfHappyAnimal) {
		this.roomTitle = roomTitle;
		this.numberOfHappyAnimal = numberOfHappyAnimal;
	}

	/**
	 * @return the roomTitle
	 */
	public String getRoomTitle() {
		return roomTitle;
	}

	/**
	 * @param roomTitle
	 *            the roomTitle to set
	 */
	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	/**
	 * @return the numberOfHappyAnimal
	 */
	public long getNumberOfHappyAnimal() {
		return numberOfHappyAnimal;
	}

	/**
	 * @param numberOfHappyAnimal
	 *            the numberOfHappyAnimal to set
	 */
	public void setNumberOfHappyAnimal(long numberOfHappyAnimal) {
		this.numberOfHappyAnimal = numberOfHappyAnimal;
	}

}
