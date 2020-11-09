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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eurail.proj.zoo.dto.AnimalReportDTO;
import com.eurail.proj.zoo.entiry.Animal;

/**
 * 
 * Repository for animal entity and reporting native queries
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	//To get List of animals in the zoo but not in the room
	@Query(name = "AnimalRepository.getZooAnimals", nativeQuery = true)
	List<AnimalReportDTO> getZooAnimals();

	//TO get List of animals in the specific rooms
	@Query(name = "AnimalRepository.getRoomAnimals", nativeQuery = true)
	public List<AnimalReportDTO> getRoomAnimals(@Param("roomId") long roomId);

	/**
	 * Find by title for Junit testing
	 * @param title
	 * @return
	 */
	public Animal findByTitle(String title);
	
}
