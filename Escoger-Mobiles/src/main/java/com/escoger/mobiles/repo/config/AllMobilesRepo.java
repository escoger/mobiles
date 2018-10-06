package com.escoger.mobiles.repo.config;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.mi.beans.AllMiMobileBean;

public interface AllMobilesRepo  {
	
//	@Query(value = "select * from mobiles")
	public List<AllMobileBean> getAllMobiles();
	public List<AllMiMobileBean> getAllMiMobiles();
	public Collection<? extends Object> getMobilesBasedOnBrand(String brand, Class clazz);

}
