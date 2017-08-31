package com.wh.singleton1;

public class MyThread2 implements Runnable{

	@Override
	public void run() {
		
		SingleTon2 singleTon2=SingleTon2.getInstance();
		System.out.println(singleTon2);
	}

}
