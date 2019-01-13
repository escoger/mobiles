package com.escoger.mobiles.services;

import java.util.List;

import com.escoger.mobiles.beans.AllMobileBean;

public interface MobileService {

	public List<AllMobileBean> getAllMobiles();

	public List<Object> getAllMobilesBasedOnBrand(String brand);

	public List<Object> getAllMobilesBasedOnBrandAndNetworkType(String brand, String networktype);

	public List<Object> getAllMobilesBrandBasedOnRecentLaunches(String brand, String recentLaunches);

	public List<Object> getAllMobilesBrandBasedOnBasicPhones(String brand, String basicphones);

	public List<Object> getAllMobilesBrandBasedOnDualSimphones(String brand, String dualsimphones);

	public List<Object> getAllAndroidMobilesBasedOnBrand(String brand);

	public List<Object> getMobilesBasedOnCamera(String camera);

	public List<Object> getMobilesBasedOnCameraAndBrand(String camera, String brand);

	public List<Object> getMobilesBasedOnCameraAndBrandAndPrice(String camera, String brand, String price);

	public List<Object> getMobilesBasedOnBrandAndOffers(String brand, String offers);

	public List<Object> getMobilesBasedOnOffers(String offers);

	public List<Object> getAllMobilesBasedOnRamAndBrand(String ram, String brand);

	public List<Object> getAllMobilesBasedOnOsTypeAndBrand(String osType, String brand);

	public List<Object> getAllMobilesBasedOnOsType(String osType);

	public List<Object> getAllMobilesBasedOnRecentLaunchesAndBrand(String recentLaunches, String brand);

	public List<Object> getAllMobilesBasedOnRecentLaunches(String recentLaunches);

	public List<Object> getAllMobilesBasedOnNetworkTypeAndBrandAndPrice(String networktype, String brand, String price);

	public List<Object> getAllMobilesBasedOnNetworkType(String networktype);

	public List<Object> getAllMobilesBasedOnPriceAndBrand(String price, String brand);

	public List<Object> getAllMobilesBasedOnPrice(String price);
    
	public List<Object> getAllMobilesBasedOnBrands(String brands);

	public List<Object> getMobileDetails(String model);
	
}
