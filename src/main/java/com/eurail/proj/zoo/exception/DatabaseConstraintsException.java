/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * 
 * @author VK
 * 
 * 
 *         01 Nov 2020
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DatabaseConstraintsException extends DataIntegrityViolationException {


	/**
	 * Data
	 */
	private static final long serialVersionUID = 1846869008399990691L;

	public DatabaseConstraintsException(String message) {
		super(message);
	}

	public DatabaseConstraintsException(String message, Throwable cause) {
		super(message, cause);
	}

}
