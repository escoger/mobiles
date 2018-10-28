package com.escoger.mobiles.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(path = "/mobiles")//, consumes = "application/json", produces = "application/json")
public class MobileController {
	private static final Logger logger = LoggerFactory.getLogger(MobileController.class);
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

	@GetMapping("mobileBrand/{brand}/network/{networktype}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnBrandAndNetworkType(@PathVariable String brand, @PathVariable String networktype) {
		System.out.println("inside mobile controller");
		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnBrandAndNetworkType(brand, networktype), HttpStatus.OK);
	}
	//recent launches
	@GetMapping	("mobiles/mobileBrand/{brand}/recentLaunches/{recentLaunches}")
	public ResponseEntity<List<Object>> getAllMobilesBrandBasedOOnRecentLaunches(@PathVariable String brand, @PathVariable String recentLaunches) {

		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBrandBasedOnRecentLaunches(brand,recentLaunches), HttpStatus.OK);
	}
	
	//basic phones
		@GetMapping	("mobiles/mobileBrand/{brand}/basicphones{basicphones}")
		public ResponseEntity<List<Object>> getAllMobilesBrandBasedOnBasicPhones(@PathVariable String brand, @PathVariable String basicphones) {

			return new ResponseEntity<List<Object>>(mobService.getAllMobilesBrandBasedOnBasicPhones(brand,basicphones), HttpStatus.OK);
		}
		
		//dual sim mobiles/mobileBrand/{brand}/dualsimphones
		@GetMapping	("mobiles/mobileBrand/{brand}/dualsimphones{dualsimphones}")
		public ResponseEntity<List<Object>> getAllMobilesBrandBasedOnDualSimphones(@PathVariable String brand, @PathVariable String dualsimphones) {

			return new ResponseEntity<List<Object>>(mobService.getAllMobilesBrandBasedOnDualSimphones(brand,dualsimphones), HttpStatus.OK);
		}
		
		@GetMapping("mobiles/mobileBrand/{brand}/androidphones")
	public ResponseEntity<List<Object>> getAllAndroidMobilesBasedOnBrand(@PathVariable String brand) {
		return new ResponseEntity<List<Object>>(mobService.getAllAndroidMobilesBasedOnBrand(brand), HttpStatus.OK);
	}

}
