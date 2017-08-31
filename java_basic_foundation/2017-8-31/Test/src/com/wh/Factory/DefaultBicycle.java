package com.wh.Factory;

public class DefaultBicycle extends Bicycle {

	public DefaultBicycle() {
		System.out.println("缺货，请联系厂家....");
	}
	@Override
	public void move() {
		System.out.println("正在生产中.....");
	}

}
