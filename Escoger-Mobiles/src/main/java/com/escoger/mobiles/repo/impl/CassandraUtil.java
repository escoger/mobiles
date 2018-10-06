package com.escoger.mobiles.repo.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.escoger.mobiles.beans.AllMobileBean;
import com.escoger.mobiles.repo.config.AllMobilesRepo;
import com.escoger.mobiles.services.MobileService;
import com.escoger.mobiles.services.MobileServiceImpl;

@Repository
	public class CassandraUtil implements AllMobilesRepo{
	private static final Logger logger = LoggerFactory.getLogger(CassandraUtil.class);

	@Autowired
	Cluster cluster;
	   /* *//**
	     * Constant String for Keyspace
	     *//*
	    private static final String KEYSPACE = "cassandra.keyspace";
	    *//**
	     * Constant String for ContactPoints
	     *//*
	    private static final String CONTACTPOINTS = "cassandra.contactpoints";
	    *//**
	     * Constant String for Port 
	     */
	    private static final String PORT = "cassandra.port";
	    
/*
	    public CassandraUtil() {
	        System.out.println("CassandraUtil()");
	    }
	    
	    private String getKeyspaceName() {
	        return environment.getProperty(KEYSPACE);       
	    }
	    
	    private String getContactPoints() {
	        return environment
	                .getProperty(CONTACTPOINTS);        
	    }
	    
	    private int getPortNumber() {
	        return Integer.parseInt(environment
	                .getProperty(PORT));        
	    }

	    @Bean
	    public CassandraClusterFactoryBean cluster() {
	        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
	        cluster.setContactPoints(getContactPoints());
	        cluster.setPort(getPortNumber());
	        return cluster;
	    }

	    @Bean
	    public CassandraMappingContext mappingContext() {
	        return new BasicCassandraMappingContext();
	    }

	    @Bean
	    public CassandraConverter converter() {
	        return new MappingCassandraConverter(mappingContext());
	    }

	    @Bean
	    public CassandraSessionFactoryBean session() throws Exception {
	        CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
	        cassandraSessionFactoryBean.setCluster(cluster().getObject());
	        cassandraSessionFactoryBean.setKeyspaceName(getKeyspaceName());
	        cassandraSessionFactoryBean.setConverter(converter());
	        cassandraSessionFactoryBean.setSchemaAction(SchemaAction.NONE);
	        return cassandraSessionFactoryBean;
	    }*/

	private final CassandraOperations cassandraTemplate;

	public CassandraUtil(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

	
	@Bean
	public MobileService mobileService(AllMobilesRepo mobileRepository) {
		return new MobileServiceImpl(mobileRepository);
	}
	
	

	@Override
	public List<AllMobileBean> getAllMobiles() {
		// TODO Auto-generated method stub
		List<AllMobileBean> allMobileList = this.cassandraTemplate.select(QueryBuilder.select().from("mobiles"), AllMobileBean.class);
		
		return allMobileList;
	}


	/*@Override
	public List<AllMiMobileBean> getAllMiMobiles() {
		List<AllMiMobileBean> allMiMobileList = this.cassandraTemplate.select(QueryBuilder.select().from("mi_mobiles"), AllMiMobileBean.class);
		
		return allMiMobileList;
	}*/
	
		
	@Bean
	public QueryLogger queryLogger(Cluster cluster) {
	    QueryLogger queryLogger = QueryLogger.builder()
	            .build();
	    cluster.register(queryLogger);
	    return queryLogger;
	}


	public Collection<? extends Object> getMobilesBasedOnBrand(String brand, Class clazz) {
		
		List<Object> mobileList = this.cassandraTemplate.select(QueryBuilder.select().from(brand+"_mobiles"), clazz);
		
	//	System.out.println("mobileList is :"+mobileList);
		
	//	System.out.println("mobile list size is :"+mobileList.size());
		
		return mobileList;
	}


	
	
}
