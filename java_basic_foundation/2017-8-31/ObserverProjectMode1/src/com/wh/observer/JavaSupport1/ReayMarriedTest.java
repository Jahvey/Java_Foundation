package com.wh.observer.JavaSupport1;

public class ReayMarriedTest {

	/**
	 * 
	 * ���л���Ĳ���
	 * */
	public static void MarriedTest(){
		WatchedMarried fbb=new WatchedMarried("������");
		fbb.setMarriedName("�");
		fbb.setPlace("�ʹڼ���");
		
		MarryWatcher jeckChen=new MarryWatcher("����", fbb);
		MarryWatcher LiChen=new MarryWatcher("�", fbb);
		MarryWatcher HuangXiaoMing=new MarryWatcher("������", fbb);
		MarryWatcher ZW=new MarryWatcher("��ޱ", fbb);
		fbb.NotifyMarried("2016-7-6");
		fbb.deleteObserver(LiChen);
		fbb.NotifyMarried("2016-7-8");
		
		fbb.NotifyMarried("2016-7-11");
		
		
	}
	public static void main(String[] args) {

		MarriedTest();
	}

}
