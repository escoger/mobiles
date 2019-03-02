package com.escoger.mobiles.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.services.MobileService;


@RestController
@RequestMapping(path = "/mobiles")//, consumes = "application/json", produces = "application/json")
@CrossOrigin(origins = "http://18.219.194.106:4200")
public class MobileController {
	private static final Logger logger = LoggerFactory.getLogger(MobileController.class);
	MobileService mobService;
	
	@Autowired
    public MobileController(MobileService mobService) {
		// TODO Auto-generated constructor stub
		this.mobService = mobService;
	}
	

	@GetMapping	("All")
	public ResponseEntity<List<AllMobileBean>> getAllMobiles() {

		return new ResponseEntity<List<AllMobileBean>>(mobService.getAllMobiles(), HttpStatus.OK);
	}
	
	@GetMapping	("mobileBrand/{brand}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnBrand(@PathVariable String brand) {
		List<Object> objectList = mobService.getAllMobilesBasedOnBrand(brand);
		if(objectList == null) {
			//throw new BrandNotFoundException("brand - "+brand);
			// call rest for all the mobiles and reder that on the UI 
		}
		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnBrand(brand), HttpStatus.OK);
	}
	
	@GetMapping	("mobileBrands/{brands}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnBrands(@PathVariable String brands) {

		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnBrands(brands), HttpStatus.OK);
	}
	
	@GetMapping	("mobilePrice/{price}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnPrice(@PathVariable String price) {

		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnPrice(price), HttpStatus.OK);
	}
	
	@GetMapping("mobilePrice/{price}/mobileBrand/{brand}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnPriceAndBrand(@PathVariable String price, @PathVariable String brand) {
		System.out.println("inside mobile controller");
		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnPriceAndBrand(price, brand), HttpStatus.OK);
	}
	
   //brand and network type
	@GetMapping("network/{networktype}/mobileBrand/{brand}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnNetworkTypeAndBrand(@PathVariable String networktype,@PathVariable String brand) {
		System.out.println("inside mobile controller");
		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnNetworkTypeAndBrand(networktype, brand), HttpStatus.OK);
	}
	
	//netwrok type
	@GetMapping("network/{networktype}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnNetworkType(@PathVariable String networktype) {
		System.out.println("inside mobile controller");
		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnNetworkType(networktype), HttpStatus.OK);
	}
	
	
	// netwrok type and brand and price
		@GetMapping("network/{networktype}/mobileBrand/{brand}/mobilePrice/{price}")
		public ResponseEntity<List<Object>> getAllMobilesBasedOnNetworkTypeAndBrandAndPrice(@PathVariable String networktype,@PathVariable String brand,@PathVariable String price) {
			System.out.println("inside mobile controller");
			return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnNetworkTypeAndBrandAndPrice(networktype,brand,price), HttpStatus.OK);
		}
	
	

	
	//recent launches
	@GetMapping	("recentLaunches")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnRecentLaunches() {

		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnRecentLaunches(), HttpStatus.OK);
	}
	
	//recent launches and brand
	@GetMapping	("recentLaunches/mobileBrand/{brand}")
	public ResponseEntity<List<Object>> getAllMobilesBasedOnRecentLaunchesAndBrand(@PathVariable String brand) {

		return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnRecentLaunchesAndBrand(brand), HttpStatus.OK);
	}
	
	//basic phones//need to discuss
		@GetMapping	("mobiles/mobileBrand/{brand}/basicphones{basicphones}")
		public ResponseEntity<List<Object>> getAllMobilesBrandBasedOnBasicPhones(@PathVariable String brand, @PathVariable String basicphones) {

			return new ResponseEntity<List<Object>>(mobService.getAllMobilesBrandBasedOnBasicPhones(brand,basicphones), HttpStatus.OK);
		}
		
		//dual sim mobiles/mobileBrand/{brand}/dualsimphones//need to discuss
		@GetMapping	("mobiles/mobileBrand/{brand}/dualsimphones{dualsimphones}")
		public ResponseEntity<List<Object>> getAllMobilesBrandBasedOnDualSimphones(@PathVariable String brand, @PathVariable String dualsimphones) {

			return new ResponseEntity<List<Object>>(mobService.getAllMobilesBrandBasedOnDualSimphones(brand,dualsimphones), HttpStatus.OK);
		}
		
		//os type
				@GetMapping	("OsType/{osType}")
				public ResponseEntity<List<Object>> getAllMobilesBasedOnOsType(@PathVariable String osType) {

					return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnOsType(osType), HttpStatus.OK);
				}
				
				//os type and brand
				@GetMapping	("OsType/{osType}/mobileBrand/{brand}")
				public ResponseEntity<List<Object>> getAllMobilesBasedOnOsTypeAndBrand(@PathVariable String osType,@PathVariable String brand) {

					return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnOsTypeAndBrand(osType,brand), HttpStatus.OK);
				}
				
				//ram
				@GetMapping	("ram/{ram}")
				public ResponseEntity<List<Object>> getAllMobilesBasedOnRam(@PathVariable String ram) {

					return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnRam(ram), HttpStatus.OK);
				}
				
				//ram and brand
				@GetMapping	("ram/{ram}/mobileBrand/{brand}")
				public ResponseEntity<List<Object>> getAllMobilesBasedOnRamAndBrand(@PathVariable String ram,@PathVariable String brand) {

					return new ResponseEntity<List<Object>>(mobService.getAllMobilesBasedOnRamAndBrand(ram,brand), HttpStatus.OK);
				}
				
				//offers
				@GetMapping	("offers")
				public ResponseEntity<List<Object>> getMobilesBasedOnOffers() {

					return new ResponseEntity<List<Object>>(mobService.getMobilesBasedOnOffers(), HttpStatus.OK);
				}
				
				
				//brand and offers
				
				@GetMapping	("brandoffers/{brand}")
				public ResponseEntity<List<Object>> getMobilesBasedOnBrandAndOffers(@PathVariable String brand) {

					return new ResponseEntity<List<Object>>(mobService.getMobilesBasedOnBrandAndOffers(brand), HttpStatus.OK);
				}
				
                //camera and brand and price
				
				@GetMapping	("camera/{camera}/mobileBrand/{brand}/mobilePrice/{price}")
				public ResponseEntity<List<Object>> getMobilesBasedOnCameraAndBrandAndPrice(@PathVariable String camera,@PathVariable String brand,@PathVariable String price) {

					return new ResponseEntity<List<Object>>(mobService.getMobilesBasedOnCameraAndBrandAndPrice(camera,brand,price), HttpStatus.OK);
				}
				
				
               //camera and brand
				
				@GetMapping	("camera/{camera}/mobileBrand/{brand}")
				public ResponseEntity<List<Object>> getMobilesBasedOnCameraAndBrand(@PathVariable String camera,@PathVariable String brand) {

					return new ResponseEntity<List<Object>>(mobService.getMobilesBasedOnCameraAndBrand(camera,brand), HttpStatus.OK);
				}
             //camera
				
				@GetMapping	("camera/{camera}")
				public ResponseEntity<List<Object>> getMobilesBasedOnCamera(@PathVariable String camera) {

					return new ResponseEntity<List<Object>>(mobService.getMobilesBasedOnCamera(camera), HttpStatus.OK);
				}
				
				
	  @GetMapping("mobiles/mobileBrand/{brand}/androidphones")
	  public ResponseEntity<List<Object>> getAllAndroidMobilesBasedOnBrand(@PathVariable String brand) {
		return new ResponseEntity<List<Object>>(mobService.getAllAndroidMobilesBasedOnBrand(brand), HttpStatus.OK);
	}
	  
	  @GetMapping("mobiledetails/{model_number}")
	  public ResponseEntity<List<Object>> getMobileDetails(@PathVariable String model_number) {
		return new ResponseEntity<List<Object>>(mobService.getMobileDetails(model_number), HttpStatus.OK);
	}

}
