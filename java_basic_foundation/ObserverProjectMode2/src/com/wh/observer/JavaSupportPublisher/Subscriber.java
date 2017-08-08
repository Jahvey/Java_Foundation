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
		System.out.println(publisher.getName()+"������"+this.name+"��"+publisher.getWedding().getData()+//
				"����һ�죬��"+publisher.getWedding().getPlace()+"���к����Ļ��񣬻�ӭ�μӡ�");
	}

}
