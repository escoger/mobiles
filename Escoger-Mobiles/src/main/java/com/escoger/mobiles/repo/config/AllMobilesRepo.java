package com.escoger.mobiles.repo.config;

import java.util.Collection;
import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;

import com.escoger.mobiles.beans.AllMobileBean;

public interface AllMobilesRepo  {
	
//	@Query(value = "select * from mobiles")
	public List<AllMobileBean> getAllMobiles();
	public Collection<? extends Object> getMobilesBasedOnBrand(String brand, Class clazz);
	public Collection<? extends Object> getAllMobilesBasedOnBrandAndNetworkType(String brand, String networkType,Class clazz);
    public Collection<? extends Object> getAllMobilesBrandBasedOnRecentLaunches(String brand, String recentLaunches,Class clazz);
    public Collection<? extends Object> getAllMobilesBrandBasedOnBasicPhones(String brand, String basicPhones, Class clazz);
	public Collection<? extends Object> getAllMobilesBrandBasedOnDualSimphones(String brand, String dualSimphones,Class clazz);
	public Collection<? extends Object> getAllAndriodMobilesBasedOnBrand(String brand, Class clazz);
	public Collection<? extends Object> getMobilesBasedOnCamera(String camera, Class clazz);
    public Collection<? extends Object> getMobilesBasedOnCameraAndBrand(String camera, String brand, Class clazz);
    public Collection<? extends Object> getMobilesBasedOnCameraAndBrandAndPrice(String camera, String brand, String price, Class clazz);
    public Collection<? extends Object> getMobilesBasedOnBrandAndOffers(String brand, String offers, Class clazz);
    public Collection<? extends Object> getMobilesBasedOnOffers(String offers, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnRamAndBrand(String ram, String brand, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnOsTypeAndBrand(String osType, String brand, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnOsType(String osType, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnRecentLaunchesAndBrand(String recentLaunches, String brand, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnRecentLaunches(String recentLaunches, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnNetworkTypeAndBrandAndPrice(String networktype, String brand, String price, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnNetworkType(String networktype, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnPriceAndBrand(String price, String brand, Class clazz);
    public Collection<? extends Object> getAllMobilesBasedOnPrice(String price, Class clazz);
	public Collection<? extends Object> getAllMobilesBasedOnBrands(String brands, Class clazz);
	public Collection<? extends Object> getMobileDetails(String model_no, Class clazz);
	
}
