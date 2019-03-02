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
			 clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			 allMobileList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnBrand(brand,clazz));
		}
		
		catch(Exception e1) {
			//e1.printStackTrace();
		}
		logger.info("EXIT :List<Object> getAllMobilesBasedOnBrand(String brand) :"+brand);
		return allMobileList;
	}

	@Override
	public List<Object> getAllMobilesBasedOnNetworkTypeAndBrand(String networkType, String brand) {
		List<Object> allMobileBrandAndNetworkTypeList = null;
		Class clazz = null;
		try {
			clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("clazz is :" + clazz);
		allMobileBrandAndNetworkTypeList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnNetworkTypeAndBrand(networkType, brand ,clazz));
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
			 clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
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
				 clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
				 System.out.println("clazz is :"+clazz);
				 AllMobilesBrandBasedOnBasicPhonesList = new ArrayList<Object>(mobileDao.getAllMobilesBrandBasedOnBasicPhones(brand,clazz));
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
				 clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
				 System.out.println("clazz is :"+clazz);
				 AllMobilesBrandBasedOnDualSimphonesList = new ArrayList<Object>(mobileDao.getAllMobilesBrandBasedOnDualSimphones(brand,clazz));
			}
			
			catch(Exception e1) {
				e1.printStackTrace();
			}
		
			return AllMobilesBrandBasedOnDualSimphonesList;
			
		}
		
		@Override
	public List<Object> getAllAndroidMobilesBasedOnBrand(String brand) {
		List<Object> allAndroidMobileBasedOnBrandList = null;
		Class clazz = null;
		try {
			clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("clazz is :" + clazz);
		allAndroidMobileBasedOnBrandList = new ArrayList<Object>(mobileDao.getAllAndriodMobilesBasedOnBrand(brand,clazz));
		return allAndroidMobileBasedOnBrandList;
	}
//new API-----
		@Override
		public List<Object> getMobilesBasedOnCamera(String camera) {
			List<Object> allMobilesBasedOnCameraList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnCameraList = new ArrayList<Object>(mobileDao.getMobilesBasedOnCamera(camera,clazz));
			return allMobilesBasedOnCameraList;
		}

		@Override
		public List<Object> getMobilesBasedOnCameraAndBrand(String camera, String brand) {
			List<Object> allMobilesBasedOnCameraAndBrandList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnCameraAndBrandList = new ArrayList<Object>(mobileDao.getMobilesBasedOnCameraAndBrand(camera,brand,clazz));
			return allMobilesBasedOnCameraAndBrandList;
		}

		@Override
		public List<Object> getMobilesBasedOnCameraAndBrandAndPrice(String camera, String brand, String price) {
			List<Object> allMobilesBasedOnCameraAndBrandAndPriceList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnCameraAndBrandAndPriceList = new ArrayList<Object>(mobileDao.getMobilesBasedOnCameraAndBrandAndPrice(camera,brand,price,clazz));
			return allMobilesBasedOnCameraAndBrandAndPriceList;
		}

		@Override
		public List<Object> getMobilesBasedOnBrandAndOffers(String brand) {
			List<Object> allMobilesBasedOnBrandAndOffersList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnBrandAndOffersList = new ArrayList<Object>(mobileDao.getMobilesBasedOnBrandAndOffers(brand,clazz));
			return allMobilesBasedOnBrandAndOffersList;
		}

		@Override
		public List<Object> getMobilesBasedOnOffers() {
			List<Object> allMobilesBasedOnOffersList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnOffersList = new ArrayList<Object>(mobileDao.getMobilesBasedOnOffers(clazz));
			return allMobilesBasedOnOffersList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnRamAndBrand(String ram, String brand) {
			List<Object> allMobilesBasedOnRamAndBrandList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnRamAndBrandList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnRamAndBrand(ram,brand,clazz));
			return allMobilesBasedOnRamAndBrandList;
		}
		
		@Override
		public List<Object> getAllMobilesBasedOnRam(String ram) {
			List<Object> allMobilesBasedOnRamAndBrandList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnRamAndBrandList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnRam(ram,clazz));
			return allMobilesBasedOnRamAndBrandList;
		}
		

		@Override
		public List<Object> getAllMobilesBasedOnOsTypeAndBrand(String osType, String brand) {
			List<Object> allMobilesBasedOnOsTypeAndBrandList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnOsTypeAndBrandList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnOsTypeAndBrand(osType,brand,clazz));
			return allMobilesBasedOnOsTypeAndBrandList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnOsType(String osType) {
			List<Object> allMobilesBasedOnOsTypeList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnOsTypeList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnOsType(osType,clazz));
			return allMobilesBasedOnOsTypeList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnRecentLaunchesAndBrand(String brand) {
			List<Object> allMobilesBasedOnRecentLaunchesAndBrandList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnRecentLaunchesAndBrandList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnRecentLaunchesAndBrand(brand,clazz));
			return allMobilesBasedOnRecentLaunchesAndBrandList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnRecentLaunches() {
			List<Object> allMobilesBasedOnRecentLaunchesList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnRecentLaunchesList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnRecentLaunches(clazz));
			return allMobilesBasedOnRecentLaunchesList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnNetworkTypeAndBrandAndPrice(String networktype, String brand,String price) {
			List<Object> allMobilesBasedOnNetworkTypeAndBrandAndPriceList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnNetworkTypeAndBrandAndPriceList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnNetworkTypeAndBrandAndPrice(networktype,brand,price,clazz));
			return allMobilesBasedOnNetworkTypeAndBrandAndPriceList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnNetworkType(String networktype) {
			 List<Object> allMobilesBasedOnNetworkTypeList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnNetworkTypeList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnNetworkType(networktype,clazz));
			return allMobilesBasedOnNetworkTypeList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnPriceAndBrand(String price, String brand) {
			List<Object> allMobilesBasedOnPriceAndBrandList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnPriceAndBrandList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnPriceAndBrand(price,brand,clazz));
			return allMobilesBasedOnPriceAndBrandList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnPrice(String price) {
			List<Object> allMobilesBasedOnPriceList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnPriceList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnPrice(price,clazz));
			return allMobilesBasedOnPriceList;
		}

		@Override
		public List<Object> getAllMobilesBasedOnBrands(String brands) {
			List<Object> allMobilesBasedOnBrandsList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			allMobilesBasedOnBrandsList = new ArrayList<Object>(mobileDao.getAllMobilesBasedOnBrands(brands,clazz));
			return allMobilesBasedOnBrandsList;
		}

		@Override
		public List<Object> getMobileDetails(String model_no) {
			List<Object> MobileDetailsList = null;
			Class clazz = null;
			try {
				clazz = Class.forName("com.escoger.mobiles.beans.AllMobileBean");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("clazz is :" + clazz);
			MobileDetailsList = new ArrayList<Object>(mobileDao.getMobileDetails(model_no,clazz));
			return MobileDetailsList;
		}

}
