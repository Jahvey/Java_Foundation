package com.wh.weather;

public class Test {
	
	
	
	@org.junit.Test
	public void TestMyThread(){
		int i=10;
		//do{
			
		MyThread myThread=null;
		for (int j = 0; j < 10; j++) {
			myThread=new MyThread();
			
			Thread t=new Thread(myThread);
			t.start();
			try {
				t.sleep(2);//线程休眠1毫秒正常工作，是cpu的问题
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			
		//}while(--i>0);
		
		
		
		
	}

}
