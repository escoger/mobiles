package com.escoger.mobiles.services;

import java.util.List;

import javax.validation.Valid;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.request.beans.MobilesOnBrandPriceRangeInputBean;

public interface MobileService {
	
	
	public List<AllMobileBean> getAllMobiles();
	public List<Object> getAllMobilesBasedOnBrand(String brand);
	public List<Object> getMobilesOnBrandPriceRange(MobilesOnBrandPriceRangeInputBean inputBean);

}

