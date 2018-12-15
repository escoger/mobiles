package com.escoger.mobiles.repo.config;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.request.beans.MobilesOnBrandPriceRangeInputBean;

public interface AllMobilesRepo  {
	
//	@Query(value = "select * from mobiles")
	public List<AllMobileBean> getAllMobiles();
	public Collection<? extends Object> getMobilesBasedOnBrand(String brand, Class clazz);
	public Collection<? extends Object> getMobilesOnBrandPriceRange(Class<AllMobileBean> class1,
			@Valid MobilesOnBrandPriceRangeInputBean inputBean);

}
