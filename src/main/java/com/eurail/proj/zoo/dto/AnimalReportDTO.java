/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * Data transfer object for display animal data in report
 * @author VK
 * 
 * 
 * 01 Nov 2020
 */
public class AnimalReportDTO {

	private String title;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date located;
	
	public AnimalReportDTO() {
	}
	
	public AnimalReportDTO(String title, Date located) {
		this.title = title;
		this.located = located;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
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
	 * @param located the located to set
	 */
	public void setLocated(Date located) {
		this.located = located;
	}

}
