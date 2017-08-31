package com.wh.observer.JavaSupportPublisher;


import java.util.ArrayList;
import java.util.List;


public class WeddingTest {

	public static void main(String[] args) {
		TestWedding();
		
		
		
	}

	private static void TestWedding() {
		Wedding wedding=new Wedding("»Ê¼Ò»¨Ô°", "2017-8-1");
		Wedding wedding2=new Wedding("»Ê¼Ò»¨Ô°", "2017-8-11");
		Publisher publisher=new Publisher("·¶±ù±ù");
		List<Subscriber> listSubs=new ArrayList<Subscriber>();
		listSubs.add(new Subscriber("³ÉÁú", publisher));
		listSubs.add(new Subscriber("Áõ»¶", publisher));
		listSubs.add(new Subscriber("»ÆÏşÃ÷", publisher));
		
//		Subscriber jeckChen=new Subscriber("³ÉÁú", publisher);
//		Subscriber LiChen=new Subscriber("Àî³¿", publisher);
//		Subscriber HuangXiaoMing=new Subscriber("»ÆÏşÃ÷", publisher);
//		Subscriber ZW=new Subscriber("ÕÔŞ±", publisher);
		
		
		publisher.NotifyMarried(wedding);
		publisher.NotifyMarried(wedding2);
	}
}
