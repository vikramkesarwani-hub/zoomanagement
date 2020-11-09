/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import java.util.List;

import com.eurail.proj.zoo.dto.AnimalReportDTO;
import com.eurail.proj.zoo.dto.HappyAnimalDTO;

/**
 * 
 * 
 * @author VK
 * 
 * s
 * 1 Nov 2020
 */
public interface IZooDashboardService {
	
	/**
	 * 
	 * @param sortedKey
	 * @param sortedOrder
	 * @return
	 */
	public List<AnimalReportDTO> getZooAnimals(String sortedKey, String sortedOrder);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<AnimalReportDTO> getRoomAnimals(long id);
	
	/**
	 * 
	 * @param animalId
	 * @return
	 */
	public List<String> getAnimalFavoriteRoom(long animalId);
	
	/**
	 * 
	 * @return
	 */
	public List<HappyAnimalDTO> getHappyAnimalsPerRoom();

}
