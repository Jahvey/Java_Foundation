package com.wh.observer.JavaSupport;

import java.util.Observable;
import java.util.Observer;

public class Watched extends Observable{
	private String name;
	private String data;
	private boolean IsNotify;
	
	
	public Watched(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	
	public void Married(String data){
		if (!data.equals(this.data)&&!IsNotify) {
			this.data=data;
			this.setChanged();
			this.notifyObservers();
			IsNotify=true;
		}
		
	}
	

	

}
