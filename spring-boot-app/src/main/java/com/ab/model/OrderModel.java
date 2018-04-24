/**
*
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.ab.model;

import java.util.List;

public class OrderModel {
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private List<ProductModel> cart;

	private String totalQuantity;
		
	private Float totalCost;


	public List<ProductModel> getCart() {
		return cart;
	}

	public void setCart(List<ProductModel> cart) {
		this.cart = cart;
	}

	public String getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

}
