package com.escoger.mobiles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.escoger.mobiles.beans.*;
import com.escoger.mobiles.services.MobileService;
import com.google.common.net.MediaType;

@RestController
@RequestMapping(path = "/mobiles", consumes = "application/json", produces = "application/json")
public class MobileController {

	MobileService mobService;
	
	@Autowired
    public MobileController(	MobileService mobService) {
		// TODO Auto-generated constructor stub
		this.mobService = mobService;
	}
	
	
	

	@GetMapping	("/All")
	public ResponseEntity<List<AllMobileBean>> getAllMobiles() {

		return new ResponseEntity<List<AllMobileBean>>(mobService.getAllMobiles(), HttpStatus.OK);
	}
	
	@GetMapping	("/mobileBrand/{brand}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnBrand(@PathVariable String brand) {

		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnBrand(brand), HttpStatus.OK);
	}
	
	
}
