package com.wh.invoke;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class InvokeTest1 {
	public static void main(String[] args) {
		List<Double>list=new ArrayList<>();//����ʱ��飬����ʱ��������ͽ��м��
		User u1=new User("wh1", 12, "Beijing");
		User u2=new User("wh2", 11, "Beijing");
		try {
			//Method method=List.class.getMethod("add", Integer.class);
			Method method=list.getClass().getDeclaredMethod("add", Object.class);
			System.out.println(method.getName()+"=="+Modifier.toString(method.getModifiers())+"///"
			+method.getParameterTypes()+//
					"=="+method.getDeclaringClass());
			method.invoke(list, u1);
			method.invoke(list, u2);
			//System.out.println(u1);
			//System.out.println(u2);
			System.out.println(list.get(0));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
