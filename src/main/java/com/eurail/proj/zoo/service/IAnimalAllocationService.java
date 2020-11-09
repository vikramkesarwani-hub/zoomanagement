/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import com.eurail.proj.zoo.dto.AllocationDTO;
import com.eurail.proj.zoo.entiry.Favorite;

/**
 * 
 * 
 * @author VK
 * 
 * 
 * 2 Nov 2020
 */
public interface IAnimalAllocationService {
	
	/**
	 * 
	 * @param allocationRequest
	 * @return
	 */
	public Favorite PlaceAnimal(AllocationDTO allocationRequest);
	/**
	 * 
	 * @param allocationRequest
	 * @return
	 */
	public Favorite MoveAnimal(AllocationDTO allocationRequest);
	/**
	 * 
	 * @param allocationRequest
	 * @return
	 */
	boolean RemoveAnimal(AllocationDTO allocationRequest);

}
