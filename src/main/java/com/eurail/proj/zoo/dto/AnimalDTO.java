/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Data transfer object for animal entity
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@Getter
@Setter
@Data
public class AnimalDTO {

	@NotBlank(message = "title can't be blank!!")
	@Size(min = 3, max = 100)
	private String title;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date located;

	@NotNull(message = "preference can't be null!!")
	private long preference;

	@NotNull(message = "type can't be blank!!")
	private String type;

	
	public AnimalDTO() {
		
	}
	
	/**
	 * 
	 * @param title
	 * @param located
	 * @param preference
	 * @param type
	 */
	public AnimalDTO(String title, Date located, long preference,
			String type) {

		this.title = title;
		this.located = located;
		this.preference = preference;
		this.type = type;

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

}
