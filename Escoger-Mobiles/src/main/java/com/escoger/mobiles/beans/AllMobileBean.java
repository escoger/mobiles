package com.escoger.mobiles.beans;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


//@Table("Mobiles")
public class AllMobileBean implements Serializable{
	
	 
	
	 
	private String brand ;
	private String model_no;
	private String image_url;
	private String price ;
	
	// offers  / logic of price 
	
	// can we use builder design pattern here 
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel_no() {
		return model_no;
	}
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	*/
	
	
	

}
