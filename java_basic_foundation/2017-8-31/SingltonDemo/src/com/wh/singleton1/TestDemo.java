package com.wh.singleton1;

import com.wh.singleton.MyThread1;

public class TestDemo {
	
	
	@org.junit.Test
	public  void getResult(){
/*		MyThread2 my=new MyThread2();
		for (int i = 0; i < 10; i++) {
			
			new Thread(my).start();
			new Thread(my).start();
		}*/
		
		
		for (int i = 0; i < 50; i++) {
			
			SingleTon2 singleTon1=SingleTon2.getInstance();
			SingleTon2 singleTon2=SingleTon2.getInstance();
			System.out.println(singleTon1==singleTon2);
			System.out.println(singleTon1);
		}
		
		
		
		
		
	}

}
