package com.wh.observer.JavaSupport1;

public class ReayMarriedTest {

	/**
	 * 
	 * ½øĞĞ»éÀñµÄ²ÊÅÅ
	 * */
	public static void MarriedTest(){
		WatchedMarried fbb=new WatchedMarried("·¶±ù±ù");
		fbb.setMarriedName("Àî³¿");
		fbb.setPlace("»Ê¹Ú¼ÙÈÕ");
		
		MarryWatcher jeckChen=new MarryWatcher("³ÉÁú", fbb);
		MarryWatcher LiChen=new MarryWatcher("Àî³¿", fbb);
		MarryWatcher HuangXiaoMing=new MarryWatcher("»ÆÏşÃ÷", fbb);
		MarryWatcher ZW=new MarryWatcher("ÕÔŞ±", fbb);
		fbb.NotifyMarried("2016-7-6");
		fbb.deleteObserver(LiChen);
		fbb.NotifyMarried("2016-7-8");
		
		fbb.NotifyMarried("2016-7-11");
		
		
	}
	public static void main(String[] args) {

		MarriedTest();
	}

}
