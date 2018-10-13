package com.escoger.mobiles.services;

import java.util.List;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.repo.config.AllMobilesRepo;

public interface MobileService {
	
	
	public List<AllMobileBean> getAllMobiles();
	public List<Object> getAllMobilesBasedOnBrand(String brand);
	public List<Object> getAllMobilesBasedOnBrandAndNetworkType(String brand, String networktype);
	public List<Object> getAllMobilesBrandBasedOnRecentLaunches(String brand, String recentLaunches);
	public List<Object> getAllMobilesBrandBasedOnBasicPhones(String brand, String basicphones);
	public List<Object> getAllMobilesBrandBasedOnDualSimphones(String brand, String dualsimphones);

}

