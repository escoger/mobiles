package com.escoger.mobiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.escoger.mobiles.beans.AllMobileBean;
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

}

