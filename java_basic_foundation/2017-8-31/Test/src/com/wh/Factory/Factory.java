package com.wh.Factory;

import org.junit.Test;

public class Factory {
	
	private Bicycle bicycle;
	public Bicycle Product(String name){
		if (name.equalsIgnoreCase("Huang")) {
			bicycle=new Huang();
		}else if(name.equalsIgnoreCase("Mobile")){
			bicycle=new Mobile();
			
		}else {
			bicycle=new DefaultBicycle();
		}
		
		return bicycle;
		
	}
	
	
	@Test
	public  void testBicycle(){
		
		Factory factory=new Factory();
		//Bicycle bicycle=factory.Product("Huang");
		Bicycle bicycle=factory.Product("Mobile");
		bicycle.move();
		
	}

}
