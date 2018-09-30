package com.escoger.mobiles.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.mi.services.MiServiceImpl;
import com.escoger.mobiles.repo.config.AllMobilesRepo;

public class MobileServiceImpl implements MobileService{

	private final AllMobilesRepo mobileRepository;
	
	
	
	public MobileServiceImpl(AllMobilesRepo mobileRepository) {
		this.mobileRepository = mobileRepository;
	}
	
	@Override
	public List<AllMobileBean> getAllMobiles() {
		// TODO Auto-generated method stub
		Iterable<AllMobileBean> mobileList = mobileRepository.getAllMobiles();
		return (List<AllMobileBean>) mobileList;
	}

	@Override
	public List<Object> getAllMobilesBasedOnBrand(String brand) {
		List<Object> allMobileList = null;
		
		if(brand==null || brand.equalsIgnoreCase("")) {
			// need to handle this scenario
		}
		
		if(brand.equalsIgnoreCase("Mi")) {

			allMobileList = new ArrayList<Object>(mobileRepository.getAllMiMobiles());
		}

		return allMobileList;
	}

	
}

