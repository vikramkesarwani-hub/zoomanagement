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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.eurail.proj.zoo.dto.HappyAnimalDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 
 * @author DiviHome
 * 
 * 
 *         30 Oct 2020
 */
@Entity
@Table(name = "room_table")
@SqlResultSetMapping(name = "happyAnimalsMapping", classes = {
		@ConstructorResult(targetClass = HappyAnimalDTO.class, columns = {
				@ColumnResult(name = "roomTitle", type = String.class),
				@ColumnResult(name = "numberOfHappyAnimal", type = Long.class)})

})
@NamedNativeQueries({
		@NamedNativeQuery(name = "AnimalRepository.getHappyAnimals", query = "SELECT rm.title as roomTitle, count(an.id) as numberOfHappyAnimal FROM animal_table an "
				+ "INNER JOIN favorite_table fa ON an.id = fa.animal_id "
				+ "INNER JOIN room_table rm ON rm.id = fa.room_id "
				+ "WHERE ((an.type like '<=' and rm.size <= an.preference) "
				+ "OR (an.type like '>=' and rm.size >= an.preference)) "
				+ "GROUP BY rm.title "
				+ "HAVING count(an.id) >= 0", resultSetMapping = "happyAnimalsMapping")})
public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6080437934386100073L;

	@Id
	@GeneratedValue(generator = "room_generator")
	@SequenceGenerator(name = "room_generator", sequenceName = "room_generator", initialValue = 500, allocationSize = 1)
	private long id;

	@Column(name = "title", nullable = false, columnDefinition = "text")
	private String title;

	@Column(name = "created", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;

	@Column(name = "size", nullable = false)
	private long size;

	
	public Room() {
		
	}
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param created
	 * @param size
	 */
	public Room(long id, String title, Date created, long size) {

		this.id = id;
		this.title = title; 
		this.created = created;
		this.size = size;
	}
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

}
