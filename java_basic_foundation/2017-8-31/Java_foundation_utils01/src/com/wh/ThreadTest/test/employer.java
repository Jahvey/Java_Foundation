package com.wh.ThreadTest.test;

public class employer implements Runnable {

	private static int count = 100;
	private static int back=0;
	private static int front=0;


	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		employer.count = count;
	}


	public static int getBack() {
		return back;
	}


	public static void setBack(int back) {
		employer.back = back;
	}


	public static int getFront() {
		return front;
	}


	public static void setFront(int front) {
		employer.front = front;
	}


	@Override
	public void run() {
		while (count > 1) {
		synchronized (this) {
			if("ǰ��".equals(Thread.currentThread().getName())){
				front++;
			}else if("����".equals(Thread.currentThread().getName())){
				back++;
			}	
		
			System.out.println("��"+count--+"��Ա������"+//
				Thread.currentThread().getName()+"����ȡ����˫ɫ��ĺ���Ϊ��"+Lottery.getResult());
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
