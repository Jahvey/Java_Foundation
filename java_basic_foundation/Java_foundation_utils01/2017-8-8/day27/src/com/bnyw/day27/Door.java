package com.bnyw.day27;

public class Door implements Runnable{
	private static int amount=100; 
	private static int front=0;
	private static int back=0;	
	
	
	public static int getAmount() {
		return amount;
	}

	public static void setAmount(int amount) {
		Door.amount = amount;
	}

	public static int getFront() {
		return front;
	}

	public static void setFront(int front) {
		Door.front = front;
	}

	public static int getBack() {
		return back;
	}

	public static void setBack(int back) {
		Door.back = back;
	}

	@Override
	public void run() {	
		while(amount>1){
			synchronized(this){
				if("ǰ��".equals(Thread.currentThread().getName())){
					front++;
				}else if("����".equals(Thread.currentThread().getName())){
					back++;
				}		
				
				System.out.println("���Ϊ: "+amount+" ��Ա���� "+Thread.currentThread().getName()+" ����ȡ����˫ɫ�����Ϊ��"+ ProduceNumUtil.createNum());
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				amount--;
			}
		}
	}
}
