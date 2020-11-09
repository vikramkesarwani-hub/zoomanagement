/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import com.eurail.proj.zoo.dto.AnimalDTO;
import com.eurail.proj.zoo.entiry.Animal;

/**
 * 
 * Service layer for Animal Entity CRUD operation
 * 
 * @author VK
 * 
 * 
 *         2 Nov 2020
 */
public interface IAnimalService {

	/**
	 * 
	 * @param animalDTO
	 * @return
	 */
	public Animal create(AnimalDTO animalDTO);

	/**
	 * 
	 * @param animal_Id
	 * @return
	 */
	public Animal read(long animal_Id);
	/**
	 * 
	 * @param animal_Id
	 * @param animalDTO
	 * @return
	 */
	public Animal update(long animal_Id, AnimalDTO animalDTO);
	/**
	 * 
	 * @param animal_Id
	 * @return
	 */
	public boolean delete(long animal_Id);

}
