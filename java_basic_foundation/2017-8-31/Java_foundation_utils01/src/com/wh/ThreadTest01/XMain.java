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
		Thread t1 = new Thread(my, "ǰ��");

		Thread t2 = new Thread(my, "����");
		t1.start();// ͬһ��mt��������Thread�оͲ����ԣ������ͬһ��ʵ��������mt���ͻ�����쳣
		
		t2.start();
		
		synchronized (XMain.class) {
			if("ǰ��".equals(t1.getName())){
				front++;
			}else if("����".equals(t2.getName())){
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
			
			System.out.println("ǰ���ܼ�:"+front+"��\t�����ܼ�:"+back+"��\t�ܼƣ�"+(100-Employers.getCount())+"��");
		}
		
	}

}
