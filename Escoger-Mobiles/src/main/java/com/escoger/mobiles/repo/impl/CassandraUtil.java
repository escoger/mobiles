package com.escoger.mobiles.repo.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.AllowFiltering;
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


	@Override
	@AllowFiltering
	public Collection<? extends Object> getAllMobilesBasedOnNetworkTypeAndBrand(String networkType, String brand, Class clazz) {
		List<AllMobileBean> allMobileBrandAndNetworkTypeList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILES_NETWORK_TYPE").where(QueryBuilder.eq("network_type", networkType)).and(QueryBuilder.eq("brand",brand)).allowFiltering(), clazz);
		return allMobileBrandAndNetworkTypeList;
	}
	
	public Collection<? extends Object> getAllMobilesBrandBasedOnRecentLaunches(String brand, String recentLaunches, Class clazz) {
		List<Object> AllMobilesBrandBasedOnRecentLaunchesList = this.cassandraTemplate.select(QueryBuilder.select().from(brand+"_mobiles").where(QueryBuilder.eq("recent_Launches",recentLaunches)), clazz);
				
				return AllMobilesBrandBasedOnRecentLaunchesList;
			}
			
			@Override
			public Collection<? extends Object> getAllMobilesBrandBasedOnBasicPhones(String brand, Class clazz) {
		List<Object> AllMobilesBrandBasedOnBasicPhonesList = this.cassandraTemplate.select(QueryBuilder.select().from("basic_mobiles").where(QueryBuilder.eq("brand",brand)), clazz);
				
				
				return AllMobilesBrandBasedOnBasicPhonesList;
			}
			
			public Collection<? extends Object> getAllMobilesBrandBasedOnDualSimphones(String brand, Class clazz) {
				List<Object> AllMobilesBrandBasedOnDualSimphonesList = this.cassandraTemplate.select(QueryBuilder.select().from("dual_mobiles").where(QueryBuilder.eq("brand",brand)), clazz);
						
						
						return AllMobilesBrandBasedOnDualSimphonesList;
					}
		
		@Override
	public Collection<? extends Object> getAllAndriodMobilesBasedOnBrand(String brand, Class clazz) {
		List<AllMobileBean> allMobileBrandAndNetworkTypeList = this.cassandraTemplate.select(QueryBuilder.select().from(brand+"_mobiles").where(QueryBuilder.eq("mobile_Type", "androidmobiles")), clazz);
		return allMobileBrandAndNetworkTypeList;
	}			


		@Override
		public Collection<? extends Object> getMobilesBasedOnCamera(String camera, Class clazz) {
			List<Object> MobilesBasedOnCameraList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_CAM_BRAND_PR").where(QueryBuilder.eq("Camera", camera)), clazz);
			
			
			return MobilesBasedOnCameraList;
		}


		@Override
		public Collection<? extends Object> getMobilesBasedOnCameraAndBrand(String camera, String brand, Class clazz) {
			List<Object> MobilesBasedOnCameraAndBrandList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_CAM_BRAND_PR").where(QueryBuilder.eq("Camera", camera)).and(QueryBuilder.eq("brand",brand)).allowFiltering(), clazz);
			
			
			return MobilesBasedOnCameraAndBrandList;
		}


		@Override
		public Collection<? extends Object> getMobilesBasedOnCameraAndBrandAndPrice(String camera, String brand,
				String price, Class clazz) {
			List<Object> MobilesBasedOnCameraAndBrandAndPriceList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_CAM_BRAND_PR").where(QueryBuilder.eq("Camera", camera)).and(QueryBuilder.eq("brand",brand)).and(QueryBuilder.eq("Best_Price",price)).allowFiltering(),  clazz);
			
			
			return MobilesBasedOnCameraAndBrandAndPriceList;
		}


		@Override
		public Collection<? extends Object> getMobilesBasedOnBrandAndOffers(String brand,Class clazz) {
			List<Object> MobilesBasedOnBrandAndOffersList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_OFFERS").where(QueryBuilder.eq("brand",brand)), clazz);
			
			
			return MobilesBasedOnBrandAndOffersList;
		}


		@Override
		public Collection<? extends Object> getMobilesBasedOnOffers(Class clazz) {
			List<Object> MobilesBasedOnOffersList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_OFFERS"), clazz);
			
			
			return MobilesBasedOnOffersList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnRamAndBrand(String ram, String brand, Class clazz) {
			List<Object> AllMobilesBasedOnRamAndBrandList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_RAM").where(QueryBuilder.eq("mob_ram", ram)).and(QueryBuilder.eq("brand",brand)).allowFiltering(), clazz);
			
			
			return AllMobilesBasedOnRamAndBrandList;
		}
		
		@Override
		public Collection<? extends Object> getAllMobilesBasedOnRam(String ram, Class clazz) {
			List<Object> AllMobilesBasedOnRamAndBrandList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_RAM").where(QueryBuilder.eq("mob_ram", ram)), clazz);
			
			
			return AllMobilesBasedOnRamAndBrandList;
		}
		


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnOsTypeAndBrand(String osType, String brand,
				Class clazz) {
			List<Object> AllMobilesBasedOnOsTypeAndBrandList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_OS_TYPE").where(QueryBuilder.eq("OS_Type", osType)).and(QueryBuilder.eq("brand",brand)).allowFiltering(), clazz);
			
			
			return AllMobilesBasedOnOsTypeAndBrandList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnOsType(String osType, Class clazz) {
			List<Object> AllMobilesBasedOnOsTypeList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_OS_TYPE").where(QueryBuilder.eq("OS_Type",osType)), clazz);
			
			
			return AllMobilesBasedOnOsTypeList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnRecentLaunchesAndBrand(String brand, Class clazz) {
			List<Object> AllMobilesBasedOnRecentLaunchesAndBrandList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILE_RECENT_LAUNCH").where(QueryBuilder.eq("brand",brand)), clazz);
			
			
			return AllMobilesBasedOnRecentLaunchesAndBrandList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnRecentLaunches(Class clazz) {
			List<Object> AllMobilesBasedOnRecentLaunchesList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILE_RECENT_LAUNCH"), clazz);
			
			
			return AllMobilesBasedOnRecentLaunchesList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnNetworkTypeAndBrandAndPrice(String networktype,
				String brand, String price, Class clazz) {
			List<Object> AllMobilesBasedOnNetworkTypeAndBrandAndPriceList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILES_NETWORK_TYPE").where(QueryBuilder.eq("network_type", networktype)).and(QueryBuilder.eq("brand",brand)).and(QueryBuilder.eq("best_price",price)).allowFiltering(), clazz);
			
			
			return AllMobilesBasedOnNetworkTypeAndBrandAndPriceList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnNetworkType(String networktype, Class clazz) {
			List<Object> AllMobilesBasedOnNetworkTypeList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILES_NETWORK_TYPE").where(QueryBuilder.eq("network_type",networktype)), clazz);
			
			
			return AllMobilesBasedOnNetworkTypeList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnPriceAndBrand(String price, String brand, Class clazz) {
			List<Object> AllMobilesBasedOnPriceAndBrandList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILES_PRICE").where(QueryBuilder.eq("Best_Price", price)).and(QueryBuilder.eq("brand",brand)).allowFiltering(), clazz);
			
			
			return AllMobilesBasedOnPriceAndBrandList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnPrice(String price, Class clazz) {
			List<Object> AllMobilesBasedOnPriceList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILES_PRICE").where(QueryBuilder.eq("Best_Price",price)), clazz);
			
			
			return AllMobilesBasedOnPriceList;
		}


		@Override
		public Collection<? extends Object> getAllMobilesBasedOnBrands(String brands, Class clazz) {
               List<Object> AllMobilesBasedOnBrandsList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILES").where(QueryBuilder.eq("brand",brands)), clazz);
			
			
			return AllMobilesBasedOnBrandsList;
		}
		
		@Override
		public Collection<? extends Object> getAllMobilesBasedOnBrand(String brand, Class clazz) {
               List<Object> AllMobilesBasedOnBrandList = this.cassandraTemplate.select(QueryBuilder.select().from("MOBILES").where(QueryBuilder.eq("brand",brand)), clazz);
			
			
			return AllMobilesBasedOnBrandList;
		}


		@Override

		

		public Collection<? extends Object> getMobileDetails(String model_number, Class clazz) {
			List<Object> AllMobileDetailsList = this.cassandraTemplate.select(QueryBuilder.select().from("MOB_DETAILS").where(QueryBuilder.eq("model_number",model_number)), clazz);

			
			return AllMobileDetailsList;
		}			

	
	
}
