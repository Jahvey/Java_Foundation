package com.wh.observer.JavaSupportPublisher;

import java.util.Observable;

public class Publisher extends  Observable{
	
	private String name;
	private Wedding wedding;
	private boolean IsNotify;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Wedding getWedding() {
		return wedding;
	}
	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}
	public Publisher(String name, Wedding wedding) {
		super();
		this.name = name;
		this.wedding = wedding;
	}
	
	
	
	public Publisher(String name) {
		super();
		this.name = name;
	}
	public void NotifyMarried(Wedding wedding) {

		if (wedding.getData() != null&&!IsNotify)//this.wedding=wedding;
		{
			
			this.setWedding(wedding);
			//this.setWedding(wedding);// 注意这里的写法，不能直接写成 setData(data);会重复
			IsNotify=true;
		}else {
			return;
		}
		System.out.println(wedding.getData());
		System.out.println(this.wedding.getData());
		if (wedding.getData().equals(this.wedding.getData())) {
			//setWedding(wedding);
			this.setChanged();
			this.notifyObservers();
		}

	}

	
	
	
	
	
	
	
	

}
