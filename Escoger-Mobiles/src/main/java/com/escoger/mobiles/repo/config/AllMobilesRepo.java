package com.escoger.mobiles.repo.config;

import java.util.Collection;
import java.util.List;

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
}
