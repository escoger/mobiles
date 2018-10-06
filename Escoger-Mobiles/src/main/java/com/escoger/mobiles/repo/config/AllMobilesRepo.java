package com.escoger.mobiles.repo.config;

import java.util.Collection;
import java.util.List;

import com.escoger.mobiles.beans.AllMobileBean;

public interface AllMobilesRepo  {
	
//	@Query(value = "select * from mobiles")
	public List<AllMobileBean> getAllMobiles();
	public Collection<? extends Object> getMobilesBasedOnBrand(String brand, Class clazz);
	public Collection<? extends Object> getAllMobilesBasedOnBrandAndNetworkType(String brand, String networkType,Class clazz);

}
