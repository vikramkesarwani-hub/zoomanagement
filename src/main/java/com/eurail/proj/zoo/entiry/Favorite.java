/**
 * Licensed Materials - Property of IBM
 * 
 * (C) Copyright IBM Corp. 2020. All Rights Reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or
 * disclosure restricted by GSA ADP Schedule Contract with IBM Corp. 
 */
package com.eurail.proj.zoo.entiry;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * 
 * @author DiviHome
 * 
 * 
 *         30 Oct 2020
 */
@Entity
@Table(name = "favorite_table") 
public class Favorite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6263391877868156562L;

	@Id
	@GeneratedValue(generator = "favorite_generator")
	@SequenceGenerator(name = "favorite_generator", sequenceName = "favorite_generator", initialValue = 10000, allocationSize = 1)
	private long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animal_id", nullable = false, insertable = false, updatable = false)
	private Animal animal;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", nullable = false, insertable = false, updatable = false)
	private Room room;

	@Column(name = "room_id", nullable = false)
	private long room_id;

	@Column(name = "animal_id", nullable = false)
	private long animal_id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the room_id
	 */
	public long getRoom_id() {
		return room_id;
	}

	/**
	 * @param room_id
	 *            the room_id to set
	 */
	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	/**
	 * @return the animal_id
	 */
	public long getAnimal_id() {
		return animal_id;
	}

	/**
	 * @param animal_id
	 *            the animal_id to set
	 */
	public void setAnimal_id(long animal_id) {
		this.animal_id = animal_id;
	}

}
