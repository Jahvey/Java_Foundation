package com.wh.singleton;

public class MyThread1 implements Runnable {

	@Override
	public void run() {
		singleton1 single=singleton1.getInstance();
		//System.out.println(single);
		System.out.println(single);

	}

}
