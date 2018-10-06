package com.escoger.mobiles.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.repo.config.AllMobilesRepo;



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

		
	
}

