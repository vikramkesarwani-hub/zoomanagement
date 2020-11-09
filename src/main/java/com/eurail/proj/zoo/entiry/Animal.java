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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.eurail.proj.zoo.dto.AnimalReportDTO;
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
@Table(name = "animal_table")
@SqlResultSetMapping(name = "zooAnimalsMapping", classes = {
		@ConstructorResult(targetClass = AnimalReportDTO.class, columns = {
				@ColumnResult(name = "title", type = String.class),
				@ColumnResult(name = "located", type = Date.class)})

})
@NamedNativeQueries({
		@NamedNativeQuery(name = "AnimalRepository.getZooAnimals", query = "SELECT an.title, an.located FROM "
				+ "Animal_table an LEFT JOIN Favorite_table fa ON "
				+ "an.id = fa.animal_id WHERE fa.animal_id is NULL "
				+ "ORDER BY title desc", resultSetMapping = "zooAnimalsMapping"),
		@NamedNativeQuery(name = "AnimalRepository.getRoomAnimals", query = "SELECT an.title, an.located FROM "
				+ "Animal_table an LEFT JOIN Favorite_table fa ON "
				+ "an.id = fa.animal_id "
				+ "WHERE fa.room_id = :roomId", resultSetMapping = "zooAnimalsMapping")})
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8139359863924044117L;

	@Id
	@GeneratedValue(generator = "animal_generator")
	@SequenceGenerator(name = "animal_generator", sequenceName = "animal_generator", initialValue = 1000, allocationSize = 1)
	private long id;

	@NotBlank
	@Size(min = 3, max = 100)
	@Column(name = "title", nullable = false, columnDefinition = "text")
	private String title;

	@Column(name = "located", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date located;

	@Column(name = "preference", nullable = false)
	private long preference;

	@Column(name = "type")
	private String type;

	public Animal() {
		
	}
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param located
	 * @param preference
	 * @param type
	 */
	public Animal(long id, String title, Date located, long preference,
			String type) {

		this.id = id;
		this.title = title;
		this.located = located;
		this.preference = preference;
		this.type = type;

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
	 * @return the located
	 */
	public Date getLocated() {
		return located;
	}

	/**
	 * @param located
	 *            the located to set
	 */
	public void setLocated(Date located) {
		this.located = located;
	}

	/**
	 * @return the preference
	 */
	public long getPreference() {
		return preference;
	}

	/**
	 * @param preference
	 *            the preference to set
	 */
	public void setPreference(long preference) {
		this.preference = preference;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
