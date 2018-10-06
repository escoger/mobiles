package com.escoger.mobiles.beans;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import com.datastax.driver.mapping.annotations.Table;

@Table(name = "mi_mobile")
public class Mi {


	@PrimaryKey
	private int id;

	private String model_No;


	private String model_name;

	private String image_Url;
	private String price ;
	private String offer;


	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getModel_No() {
		return model_No;
	}
	public void setModel_No(String model_No) {
		this.model_No = model_No;
	}

	public String getImage_Url() {
		return image_Url;
	}
	public void setImage_Url(String image_Url) {
		this.image_Url = image_Url;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

}



