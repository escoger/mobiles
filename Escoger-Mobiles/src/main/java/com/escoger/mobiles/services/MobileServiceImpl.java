package com.escoger.mobiles.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.repo.config.AllMobilesRepo;



public class MobileServiceImpl implements MobileService{
	//Logger logger = LoggerFact


	private final AllMobilesRepo mobileDao;
	
	
	
	public MobileServiceImpl(AllMobilesRepo mobileDao) {
		this.mobileDao = mobileDao;
	}
	
	@Override
	public List<AllMobileBean> getAllMobiles() {
		// TODO Auto-generated method stub
		Iterable<AllMobileBean> mobileList = mobileDao.getAllMobiles();
		return (List<AllMobileBean>) mobileList;
	}

	@Override
	public List<Object> getAllMobilesBasedOnBrand(String brand) {
		List<Object> allMobileList = null;
		Class clazz = null;
		
		if(brand==null || brand.equalsIgnoreCase("")) {
			// need to handle this scenario
		}
		
		try {
			 clazz = Class.forName("com.escoger.mobiles.mi.beans."+brand);
			 System.out.println("clazz is :"+clazz);
			 allMobileList = new ArrayList<Object>(mobileDao.getMobilesBasedOnBrand(brand,clazz));
		}
		
		catch(Exception e1) {
			e1.printStackTrace();
		}
	

		return allMobileList;
	}

		
	
}

