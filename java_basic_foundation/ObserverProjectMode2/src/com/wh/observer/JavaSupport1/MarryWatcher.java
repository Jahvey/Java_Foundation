package com.wh.observer.JavaSupport1;

import java.util.Observable;
import java.util.Observer;
/***
 * 
 * 
 * ���������ˣ����� �  ����֮��
 * */
public class MarryWatcher implements Observer {

	private String name;
	
	private WatchedMarried observable;
	
	
	public WatchedMarried getObservable() {
		return observable;
	}



	public void setObservable(WatchedMarried observable) {
		this.observable = observable;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}






	public MarryWatcher(String name,Observable obs) {
		this.name = name;
		this.observable=(WatchedMarried)obs;
		observable.addObserver(this);
	}



	@Override
	public void update(Observable o, Object arg) {
		System.out.println(this.getName()+"�յ�������"+observable.getName()+"��"+observable.getData()+"��"+observable.getPlace()+"��Ƶ�������롣");
		
	}

}
