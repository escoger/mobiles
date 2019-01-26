package com.escoger.mobiles.beans;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("mobiles")
public class AllMobileBean implements Serializable{
	
	 
	
	 
	private String brand;
	private String model_number;
	private String model_Name;
	private String image_url;
	private String price ;
	private String best_price;
	private String offer;
	private String os;
	
	
	
	
	
	
	
	

}
