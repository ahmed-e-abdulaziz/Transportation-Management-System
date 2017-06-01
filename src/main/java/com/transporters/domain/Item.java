package com.transporters.domain;

import org.springframework.stereotype.Component;

@Component
public class Item {
	private String itemName;
	private Integer quantity;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
