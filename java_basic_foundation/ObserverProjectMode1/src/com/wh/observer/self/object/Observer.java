package com.wh.observer.self.object;



public class Observer implements Observor {

	private String name;
	public Observer() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Observer(String name) {
		this.name = name;
	}

	@Override
	public boolean update(String msg) {
		System.out.println(this.name+"--"+msg);
		return true;
	}



}
