package com.wh.singleton;

import org.junit.Test;

public class singleton1 {
	/**
	 * 
	 * 
	 * 恶汉式创建设计模式
	 * 
	 * */
	private singleton1(){}
	private static   singleton1 single;
	public static singleton1  getInstance(){
		synchronized (singleton1.class) {
			if (null==single) {
				single=new singleton1();
			}
		}
		
		
		return single;
		
	}
	
	
	
	
	
	
	

}
