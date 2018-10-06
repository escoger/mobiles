package com.escoger.mobiles.factory;


public  class MobileFactory implements MobileTypeObject{

	@Override
	public Object getMobileObjectBasedOnBrand(String brand) {
		if(brand == null || brand.equalsIgnoreCase("")) {
			return new Exception();
		}
		if(brand.equalsIgnoreCase("Nokia")) {

		}
		if(brand.equalsIgnoreCase("Samsung")) {

		}
		if(brand.equalsIgnoreCase("HTC")) {

		}
		if(brand.equalsIgnoreCase("Mi")) {
			//return new AllMiMobileBean();
		}
		if(brand.equalsIgnoreCase("One plus")) {

		}
		if(brand.equalsIgnoreCase("Motorola")) {

		}
		if(brand.equalsIgnoreCase("Apple")) {

		}
		if(brand.equalsIgnoreCase("Asus")) {

		}
		if(brand.equalsIgnoreCase("Huawei")) {

		}
		if(brand.equalsIgnoreCase("Karbon")) {

		}
		if(brand.equalsIgnoreCase("Oppo")) {

		}
		if(brand.equalsIgnoreCase("Micromax")) {

		}
		if(brand.equalsIgnoreCase("Poco")) {

		}
		if(brand.equalsIgnoreCase("Sony")) {

		}
		if(brand.equalsIgnoreCase("Xolo")) {

		}
		if(brand.equalsIgnoreCase("Videocon")) {

		}
		if(brand.equalsIgnoreCase("Vivo")) {

		}

		

		return null;
	}

}
