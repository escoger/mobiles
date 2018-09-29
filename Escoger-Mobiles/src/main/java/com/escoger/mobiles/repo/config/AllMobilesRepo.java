package com.escoger.mobiles.repo.config;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.escoger.mobiles.beans.AllMobileBean;

public interface AllMobilesRepo  {
	
	@Query(value = "select * from mobiles")
	public List<AllMobileBean> getAllMobiles();

}
