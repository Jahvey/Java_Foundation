package cn.adonai.mutithread.Test01;

public class myThread1 extends Thread {
	
	private int count=9;
	//重写run方法
	@Override
	public void run() {
		while (true) {
			System.out.print(count+" ");
			if (--count==0) {
				return ;
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new myThread1().start();
	}

}
