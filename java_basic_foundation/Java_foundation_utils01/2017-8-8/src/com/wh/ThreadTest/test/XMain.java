package com.wh.ThreadTest.test;

public class XMain {
	public static void main(String[] args) {

		employer my = new employer();
		Thread t1 = new Thread(my, "ǰ��");

		Thread t2 = new Thread(my, "����");
		t1.start();// ͬһ��mt��������Thread�оͲ����ԣ������ͬһ��ʵ��������mt���ͻ�����쳣
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
		
		System.out.println("ǰ���ܼ�:"+employer.getFront()+"��\t�����ܼ�:"+employer.getBack()+"��\t�ܼƣ�"+(100-employer.getCount())+"��");
		
		

	}

}
