package com.escoger.mobiles.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.repo.config.AllMobilesRepo;
import com.escoger.mobiles.request.beans.MobilesOnBrandPriceRangeInputBean;



public class MobileServiceImpl implements MobileService{
	private static final Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);


	private final AllMobilesRepo mobileDao;
	
	
	
	public MobileServiceImpl(AllMobilesRepo mobileDao) {
		this.mobileDao = mobileDao;
	}
	
	@Override
	public List<AllMobileBean> getAllMobiles() {
		logger.info("ENTER :List<AllMobileBean> getAllMobiles");
		 Iterable<AllMobileBean> mobileList = mobileDao.getAllMobiles();
		 logger.info("EXIT :List<AllMobileBean> getAllMobiles");
		 return (List<AllMobileBean>) mobileList;
	}

	@Override
	public List<Object> getAllMobilesBasedOnBrand(String brand) {
		logger.info("ENTER :List<Object> getAllMobilesBasedOnBrand(String brand) :"+brand);
		List<Object> allMobileList = null;
		Class clazz = null;
		
		if(brand==null || brand.equalsIgnoreCase("")) {
			// need to handle this scenario
		}
		
		try {
			 clazz = Class.forName("com.escoger.mobiles.beans."+brand);
			 logger.debug("getAllMobilesBasedOnBrand - clazz :"+clazz);
			 allMobileList = new ArrayList<Object>(mobileDao.getMobilesBasedOnBrand(brand,clazz));
		}
		
		catch(Exception e1) {
			//e1.printStackTrace();
		}
		logger.info("EXIT :List<Object> getAllMobilesBasedOnBrand(String brand) :"+brand);
		return allMobileList;
	}

	/*@Override
	public List<Object> getMobilesBasedOnBrandPriceRange(Map<String, String> varsMap) {
		logger.info("ENTER :List<Object> getMobilesBasedOnBrandPriceRange(Map<String, String> varsMap) :"+varsMap);
		List<Object> allMobileList = null;
		Class clazz = null;
		String brand = null;
		if(checkValueInMap(varsMap)) {
			brand = varsMap.get("mobileBrand");
			 try {
				clazz = Class.forName("com.escoger.mobiles.beans."+brand);
				 logger.debug("getAllMobilesBasedOnBrand - clazz :"+clazz);
				 allMobileList = new ArrayList<Object>(mobileDao.getMobilesBasedOnBrandPriceRange(brand,clazz));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		
		/*logger.info("ENTER :List<Object> getMobilesBasedOnBrandPriceRange(Map<String, String> varsMap) :"+varsMap);
		return null;
	}*/

	private boolean checkValueInMap(Map<String, String> varsMap) {
		// TODO Auto-generated method stub
		if(varsMap==null)
			return false;
		
		for(String key :varsMap.keySet())
		{
			String val = varsMap.get(key);
			if(val==null) 
				return false;
		}
					
		
		return false;
	}

	@Override
	public List<Object> getMobilesOnBrandPriceRange(@Valid MobilesOnBrandPriceRangeInputBean inputBean) {
		// TODO Auto-generated method stub
		List<Object> allMobileList = null;
		 return allMobileList = new ArrayList<Object>(mobileDao.getMobilesOnBrandPriceRange(AllMobileBean.class,inputBean));
	}

		
	
}

