package com.wh.singleton3;

public class Test {
	
	@org.junit.Test
	public void TestResult(){
		for (int i = 0; i < 10; i++) {
			
			NestedClassSingleton n1=NestedClassSingleton.getNestedClassSingleton();
			NestedClassSingleton n2=NestedClassSingleton.getNestedClassSingleton();
			System.out.println(n1==n2);
			System.out.println(n1);
		}
		
		
	}

}
