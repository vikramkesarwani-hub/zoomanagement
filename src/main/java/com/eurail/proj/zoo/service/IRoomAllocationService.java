/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import com.eurail.proj.zoo.entiry.Favorite;

/**
 * 
 * Service interface for assign/unassign room use case IV
 * @author VK
 * 
 * 
 * 01 Nov 2020
 */
public interface IRoomAllocationService {

	/**
	 * Assign room
	 * @param id
	 * @return
	 */
	public Favorite AssignRoom(long id);
	
	/**
	 * unassign room
	 * @param id
	 * @return
	 */
	public String UnassignRoom(long id);
	
}
