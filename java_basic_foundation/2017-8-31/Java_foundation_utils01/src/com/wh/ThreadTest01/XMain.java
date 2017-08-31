/**
 * 
 */
package com.wh.ThreadTest01;



/**
 * @author Administrator
 *
 */
public class XMain {

	private static int back=0;
	private static int front=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestMain();
		
		
	}

	private static void TestMain() {
		Employers my = new Employers();
		Thread t1 = new Thread(my, "前门");

		Thread t2 = new Thread(my, "后门");
		t1.start();// 同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常
		
		t2.start();
		
		synchronized (XMain.class) {
			if("前门".equals(t1.getName())){
				front++;
			}else if("后门".equals(t2.getName())){
				back++;
			}	
			if (t1.isAlive()||t2.isAlive()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("前门总计:"+front+"人\t后门总计:"+back+"人\t总计："+(100-Employers.getCount())+"人");
		}
		
	}

}
