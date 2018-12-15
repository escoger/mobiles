package com.escoger.mobiles.request.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class MobilesOnBrandPriceRangeInputBean {
	
	
	//@Size(min=2 , message="Brand Name should be atleast 2 characters")
	@NotNull
	private String brand;
	
	
	private int minprice;
	
	private int maxprice;

	
	public int getMinprice() {
		return minprice;
	}

	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}

	public int getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	
	
	
	

}
