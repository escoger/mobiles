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
}
