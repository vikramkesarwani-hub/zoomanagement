/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Data transfer object for sorting key and order for report
 * 
 * @author VK
 * 
 * 
 *         1 Nov 2020
 */
@Getter
@Setter
@Data
public class SortingDTO {

	private String sortingKey;

	private String sortingOrder;

	/**
	 * @return the sortingKey
	 */
	public String getSortingKey() {
		return sortingKey;
	}

	/**
	 * @param sortingKey
	 *            the sortingKey to set
	 */
	public void setSortingKey(String sortingKey) {
		this.sortingKey = sortingKey;
	}

	/**
	 * @return the sortingOrder
	 */
	public String getSortingOrder() {
		return sortingOrder;
	}

	/**
	 * @param sortingOrder
	 *            the sortingOrder to set
	 */
	public void setSortingOrder(String sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

}
