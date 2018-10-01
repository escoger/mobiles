package com.escoger.mobiles.mi.services;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.escoger.mobiles.mi.beans.AllMiMobileBean;
import com.escoger.mobiles.repo.config.AllMobilesRepo;
import com.escoger.mobiles.services.MobileService;
import com.escoger.mobiles.services.MobileServiceImpl;

public class MiServiceImpl implements MiService{
	
	private final AllMobilesRepo mobileRepository;
	
	private AllMiMobileBean miMobileBean;
	
	public MiServiceImpl(AllMobilesRepo mobileRepository) {
		this.mobileRepository = mobileRepository;
	}
	
	
	
	@Override
	public List<AllMiMobileBean> getMiMobileBean() {
		// TODO Auto-generated method stub
		Iterable<AllMiMobileBean> mobileList = mobileRepository.getAllMiMobiles();
		return (List<AllMiMobileBean>) mobileList;
		
	}

}
