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

	@Override
	public List<Object> getAllMobilesBasedOnBrandAndNetworkType(String brand, String networkType) {
		List<Object> allMobileBrandAndNetworkTypeList = null;
		Class clazz = null;
		try {
			clazz = Class.forName("com.escoger.mobiles.beans" + brand);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("clazz is :" + clazz);
		allMobileBrandAndNetworkTypeList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnBrandAndNetworkType(brand, networkType ,clazz));
		return allMobileBrandAndNetworkTypeList;
	}
	
	@Override
	public List<Object> getAllMobilesBrandBasedOnRecentLaunches(String brand,String recentLaunches) {
		List<Object> AllMobilesBrandBasedOnRecentLaunchesList = null;
		Class clazz = null;
		
		if(brand==null || brand.equalsIgnoreCase("")) {
			// need to handle this scenario
		}
		
		try {
			 clazz = Class.forName("com.escoger.mobiles.mi.beans."+brand);
			 System.out.println("clazz is :"+clazz);
			 AllMobilesBrandBasedOnRecentLaunchesList = new ArrayList<Object>(mobileDao.getAllMobilesBrandBasedOnRecentLaunches(brand,recentLaunches,clazz));
		}
		
		catch(Exception e1) {
			e1.printStackTrace();
		}
	

		return AllMobilesBrandBasedOnRecentLaunchesList;
	}
	
	//basic sim
	
	//basic sim
	
		@Override
		public List<Object> getAllMobilesBrandBasedOnBasicPhones(String brand,String basicPhones) {
			List<Object> AllMobilesBrandBasedOnBasicPhonesList = null;
			Class clazz = null;
			
			if(brand==null || brand.equalsIgnoreCase("")) {
				// need to handle this scenario
			}
			
			try {
				 clazz = Class.forName("com.escoger.mobiles.beans."+brand);
				 System.out.println("clazz is :"+clazz);
				 AllMobilesBrandBasedOnBasicPhonesList = new ArrayList<Object>(mobileDao.getAllMobilesBrandBasedOnBasicPhones(brand,basicPhones,clazz));
			}
			
			catch(Exception e1) {
				e1.printStackTrace();
			}
		

			return AllMobilesBrandBasedOnBasicPhonesList;
		}
		
		@Override
		public List<Object> getAllMobilesBrandBasedOnDualSimphones(String brand,String DualSimphones) {
			List<Object> AllMobilesBrandBasedOnDualSimphonesList = null;
			Class clazz = null;
			
			if(brand==null || brand.equalsIgnoreCase("")) {
				// need to handle this scenario
			}
			
			try {
				 clazz = Class.forName("com.escoger.mobiles.beans."+brand);
				 System.out.println("clazz is :"+clazz);
				 AllMobilesBrandBasedOnDualSimphonesList = new ArrayList<Object>(mobileDao.getAllMobilesBrandBasedOnDualSimphones(brand,DualSimphones,clazz));
			}
			
			catch(Exception e1) {
				e1.printStackTrace();
			}
		
			return AllMobilesBrandBasedOnDualSimphonesList;
			
		}

}
