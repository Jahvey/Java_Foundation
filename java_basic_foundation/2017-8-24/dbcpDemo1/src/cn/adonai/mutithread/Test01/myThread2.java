package cn.adonai.mutithread.Test01;

public class myThread2 implements Runnable {

	private int count=11;
	@Override
	public void run() {
		while(true) {
			System.out.print(count+" ");
		if (--count==0) {
			return;
		}
		}
	}
	
	
	public static void main(String[] args) {
		new Thread(new myThread2(),"t1").start();
	}

}
