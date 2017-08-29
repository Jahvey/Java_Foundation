package com.adonai.service;

import java.util.List;

import com.adonai.bean.Student;
import com.adonai.dao.Dao;
import com.adonai.dao.DaoImpl;

//service层实现具体的业务逻辑
public class myService {
	private Dao dao = new DaoImpl();
	
	
	
	
	public boolean existed(String username,String password){
		boolean flag=false;
		List list = dao.retrieve("select * from student where name=? and password=?", Student.class, username,password);   
		
		System.out.println(username);
		System.out.println(password);
		if(list.size()>0){
			flag=true;
		}
		return flag;
	}
	
	//从数据库中取出学生信息
	public  List getStudents() {
//		List student=null;
//		student=dao.retrieve("select * from student", Student.class);
//		return student;
		return dao.retrieve("select * from student", Student.class);
	}
	
}
