package com.wh.observer.JavaSupportPublisher;


import java.util.ArrayList;
import java.util.List;


public class WeddingTest {

	public static void main(String[] args) {
		TestWedding();
		
		
		
	}

	private static void TestWedding() {
		Wedding wedding=new Wedding("�ʼһ�԰", "2017-8-1");
		Wedding wedding2=new Wedding("�ʼһ�԰", "2017-8-11");
		Publisher publisher=new Publisher("������");
		List<Subscriber> listSubs=new ArrayList<Subscriber>();
		listSubs.add(new Subscriber("����", publisher));
		listSubs.add(new Subscriber("����", publisher));
		listSubs.add(new Subscriber("������", publisher));
		
//		Subscriber jeckChen=new Subscriber("����", publisher);
//		Subscriber LiChen=new Subscriber("�", publisher);
//		Subscriber HuangXiaoMing=new Subscriber("������", publisher);
//		Subscriber ZW=new Subscriber("��ޱ", publisher);
		
		
		publisher.NotifyMarried(wedding);
		publisher.NotifyMarried(wedding2);
	}
}
