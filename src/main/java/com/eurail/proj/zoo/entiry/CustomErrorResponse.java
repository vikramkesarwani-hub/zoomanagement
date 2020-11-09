/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.entiry;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 
 * @author VK
 * 
 * 
 *         2 Nov 2020
 */
public class CustomErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	/**
	 * 
	 * @return Timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * 
	 * @return String
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * 
	 * @return  String
	 */
	public String getError() {
		return error;
	}
	/**
	 * 
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}

}
