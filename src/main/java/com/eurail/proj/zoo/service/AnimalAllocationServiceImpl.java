/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurail.proj.zoo.dto.AllocationDTO;
import com.eurail.proj.zoo.entiry.Favorite;
import com.eurail.proj.zoo.repository.FavoriteRepository;

/**
 * 
 * 
 * @author VK
 * 
 * 
 *         2 Nov 2020
 */
@Service
public class AnimalAllocationServiceImpl implements IAnimalAllocationService {

	@Autowired
	private FavoriteRepository favRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zoo.service.AnimalAllocationService#PlaceAnimal(com.
	 * eurail.proj.zoo.dto.AllocationDTO)
	 */
	@Override
	public Favorite PlaceAnimal(AllocationDTO allocationRequest) {

		ModelMapper modelMapper = new ModelMapper();
		Favorite fav = modelMapper.map(allocationRequest, Favorite.class);
		favRepository.deleteByAnimal_id(allocationRequest.getAnimal_id());
		return favRepository.save(fav);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zoo.service.AnimalAllocationService#MoveAnimal(com.eurail
	 * .proj.zoo.dto.AllocationDTO)
	 */
	@Override
	public Favorite MoveAnimal(AllocationDTO allocationRequest) {

		favRepository.deleteByAnimal_id(allocationRequest.getAnimal_id());
		Favorite fav = new Favorite();
		fav.setAnimal_id(allocationRequest.getAnimal_id());
		fav.setRoom_id(allocationRequest.getRoom_id());
		return favRepository.save(fav);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zoo.service.AnimalAllocationService#RemoveAnimal(com.
	 * eurail.proj.zoo.dto.AllocationDTO)
	 */
	@Override
	public boolean RemoveAnimal(AllocationDTO allocationRequest) {

		favRepository.deleteByAnimal_id(allocationRequest.getAnimal_id());
		return true;
	}

}
