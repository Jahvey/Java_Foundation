package com.wh.ThreadTest01;



public class Employers implements Runnable{

	private static int count=100;
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Employers.count = count;
	}
	@Override
	public void run() {
		while (count>1) {
			synchronized (this) {
				
				System.out.println("第"+count--+"名员工，从"+//
						Thread.currentThread().getName()+"出，取出的双色球的号码为："+CaiPiao.getResult());
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}

}
