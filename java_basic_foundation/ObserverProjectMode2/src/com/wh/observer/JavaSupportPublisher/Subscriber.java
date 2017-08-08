package com.wh.observer.JavaSupportPublisher;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {

	private String name;
	private Publisher publisher;
	
	public Subscriber(String name) {
		super();
		this.name = name;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	
	
	

	

	public Subscriber(String name, Observable publisher) {
		//super();
		this.name = name;
		
		this.publisher = (Publisher)publisher;
		publisher.addObserver(this);
	
	}



	@Override
	public void update(Observable o, Object arg) {
		System.out.println(publisher.getName()+"邀请了"+this.name+"于"+publisher.getWedding().getData()+//
				"的那一天，在"+publisher.getWedding().getPlace()+"举行豪华的婚礼，欢迎参加。");
	}

}
