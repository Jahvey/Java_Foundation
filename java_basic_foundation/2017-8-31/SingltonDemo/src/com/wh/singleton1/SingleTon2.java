package com.wh.singleton1;

public class SingleTon2 {
	private SingleTon2(){}
	private static  SingleTon2 singleTon2=new SingleTon2();
	public  static SingleTon2 getInstance(){
		if (null==singleTon2) {
			singleTon2=new SingleTon2();
		}
		return singleTon2;
	}

}
