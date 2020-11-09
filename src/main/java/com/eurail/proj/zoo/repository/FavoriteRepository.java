/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eurail.proj.zoo.entiry.Favorite;

/**
 * 
 * Repository for favorite entity and reporting native queries
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

	/**
	 * Query to delete data from Favorite table based on animal id
	 * @param animal_id
	 */
	@Transactional
	@Modifying
	@Query("delete FROM Favorite fav WHERE fav.animal_id = :animal_id")
	void deleteByAnimal_id(@Param("animal_id") long animal_id);

	/**
	 *  Query to fetch data from Favorite table based on animal id
	 * @param animal_id
	 * @return
	 */
	@Query("SELECT fav FROM Favorite fav WHERE fav.animal_id = :animal_id")
	Favorite findByAnimal_id(@Param("animal_id") long animal_id);

}
