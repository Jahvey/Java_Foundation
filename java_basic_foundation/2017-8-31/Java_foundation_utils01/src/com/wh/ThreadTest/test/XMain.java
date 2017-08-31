package com.wh.ThreadTest.test;

public class XMain {
	public static void main(String[] args) {

		employer my = new employer();
		Thread t1 = new Thread(my, "前门");

		Thread t2 = new Thread(my, "后门");
		t1.start();// 同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常
		// new Thread(my, "E").start();
		t2.start();
		if (t1.isAlive()||t2.isAlive()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("前门总计:"+employer.getFront()+"人\t后门总计:"+employer.getBack()+"人\t总计："+(100-employer.getCount())+"人");
		
		

	}

}
