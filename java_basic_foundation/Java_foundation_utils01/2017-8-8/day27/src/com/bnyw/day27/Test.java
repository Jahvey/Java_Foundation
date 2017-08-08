package com.bnyw.day27;

public class Test {
	public static void main(String[] args) throws Exception{
		letRun();
	}
	
	public static void letRun() throws InterruptedException{
		Door door = new Door();
		Thread front = new Thread(door,"ǰ��");
		Thread back = new Thread(door,"����");
		/*front.setName("ǰ��");
		back.setName("����");*/
		front.start();		
		back.start();
		while(front.isAlive()||back.isAlive()){
			Thread.sleep(50);
		}
		System.out.println("front:"+Door.getFront()+"\tback:"+Door.getBack());
	}	
}
