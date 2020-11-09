/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eurail.proj.zoo.dto.HappyAnimalDTO;
import com.eurail.proj.zoo.entiry.Room;

/**
 * 
 * Repository for room entity and reporting native queries
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	/**
	 * Size *LessThanEqual* preference
	 * @param preference
	 * @return
	 */
	List<Room> findBySizeLessThanEqual(long preference);

	/**
	 * Size *GreaterThanEqual* preference
	 * @param preference
	 * @return
	 */
	List<Room> findBySizeGreaterThanEqual(long preference);

	/**
	 * Result for happy animals this query will return data of all happy animal in rooms.
	 * @return
	 */
	@Query(name = "AnimalRepository.getHappyAnimals", nativeQuery = true)
	public List<HappyAnimalDTO> getHappyAnimals();

}
