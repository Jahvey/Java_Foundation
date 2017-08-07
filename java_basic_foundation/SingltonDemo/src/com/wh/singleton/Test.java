package com.wh.singleton;



public class Test {

	@org.junit.Test
	public  void getResult(){
		MyThread1 my=new MyThread1();
		for (int i = 0; i < 10; i++) {
			
			new Thread(my).start();
			new Thread(my).start();
		}
		
		
	}
}
