package com.escoger.mobiles.beans;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("mobiles")
public class AllMobileBean implements Serializable{
	
	 
	 @PrimaryKey
	 private UUID id;
	 
	private String brand ;
	private String model_no;
	private String image_url;
	private String price ;
	private String networktype;
	private String offer;
	
	// offers  / logic of price 
	
	// can we use builder design pattern here 
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public String getNetworktype() {
		return networktype;
	}
	public void setNetworktype(String networktype) {
		this.networktype = networktype;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	 
	
	
	
	

}
