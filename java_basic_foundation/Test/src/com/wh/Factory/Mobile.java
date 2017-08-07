package com.wh.Factory;

public class Mobile extends Bicycle {

	public Mobile() {
		System.out.println("mobike正在生产中....");
	}
	@Override
	public void move() {
		System.out.println("mobike可以骑了....");
	}

}
