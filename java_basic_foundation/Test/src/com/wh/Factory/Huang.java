package com.wh.Factory;

public class Huang extends Bicycle {

	public Huang() {
		System.out.println("小黄车正在生产中....");
	}
	@Override
	public void move() {
		System.out.println("小黄车可以骑了....");

	}

}
