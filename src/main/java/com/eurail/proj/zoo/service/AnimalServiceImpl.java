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

import com.eurail.proj.zoo.dto.AnimalDTO;
import com.eurail.proj.zoo.entiry.Animal;
import com.eurail.proj.zoo.exception.ResourceNotFoundException;
import com.eurail.proj.zoo.repository.AnimalRepository;

/**
 * 
 * 
 * @author VK
 * 
 * 
 *         2 Nov 2020
 */
@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private AnimalRepository anmlRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurail.proj.zoo.service.AnimalService#create(com.eurail.proj.zoo.dto.
	 * AnimalDTO)
	 */
	@Override
	public Animal create(AnimalDTO animalDTO) { 

		ModelMapper modelMapper = new ModelMapper();
		return anmlRepository.save(modelMapper.map(animalDTO, Animal.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zoo.service.AnimalService#read(long)
	 */
	@Override
	public Animal read(long animal_Id) {
		Animal aml = anmlRepository.findById(animal_Id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Animal not found with id " + animal_Id));
		return aml;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zoo.service.AnimalService#update(long,
	 * com.eurail.proj.zoo.dto.AnimalDTO)
	 */
	@Override
	public Animal update(long animal_Id, AnimalDTO animalDTO)
			throws ResourceNotFoundException {

		Animal aml = anmlRepository.findById(animal_Id).map(anml -> {
			anml.setTitle(animalDTO.getTitle());
			anml.setPreference(animalDTO.getPreference());
			anml.setType(animalDTO.getType());
			anml.setLocated(animalDTO.getLocated());
			return anmlRepository.save(anml);
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Animal not found with id " + animal_Id));

		return aml;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eurail.proj.zoo.service.AnimalService#delete(long)
	 */
	@Override
	public boolean delete(long animal_Id) throws ResourceNotFoundException {

		anmlRepository.findById(animal_Id).map(anml -> {
			anmlRepository.delete(anml);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Animal not found with id " + animal_Id));
		return true;
	}

}
