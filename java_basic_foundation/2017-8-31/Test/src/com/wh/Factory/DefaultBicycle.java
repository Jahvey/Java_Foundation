package com.wh.Factory;

public class DefaultBicycle extends Bicycle {

	public DefaultBicycle() {
		System.out.println("ȱ��������ϵ����....");
	}
	@Override
	public void move() {
		System.out.println("����������.....");
	}

}
