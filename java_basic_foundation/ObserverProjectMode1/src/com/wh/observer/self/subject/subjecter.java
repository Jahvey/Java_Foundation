package com.wh.observer.self.subject;

import java.util.ArrayList;
import java.util.List;

import com.wh.observer.self.object.Observor;



public class subjecter implements Subjector {
	
	private String name;
	private String data;
	
	private List<Observor> listObserver=new ArrayList<>();

	public subjecter() {
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

	public void setData(String data) {
		this.data = data;
	}

	
	public subjecter(String name) {
		this.name = name;
	}



	@Override
	public void attach(Observor o) {
		listObserver.add(o);

	}

	@Override
	public void attachs(List<Observor> listObservers) {
		listObserver.addAll(listObservers);

	}

	@Override
	public boolean delobj(Observor o) {
		listObserver.remove(o);
		return true;
	}

	@Override
	public boolean delobjs(List<Observor> listObservers) {
		listObserver.removeAll(listObservers);
		return true;
	}

	public boolean notifyObject(String msg) {
		for (Observor observor : listObserver) {
			observor.update(msg);
		}
		return true;
	}



}
