package com.adonai.service;

import java.util.List;

import com.adonai.bean.Admin;
import com.adonai.dao.Dao;
import com.adonai.dao.DaoImpl;


public class AdminService {
	
	private Dao dao = new DaoImpl();
	public boolean existed(String username,String password){
		boolean flag=false;
		List list = dao.retrieve("select * from admin where adminName=? and adminPwd=?", Admin.class, username,password);   
		
		System.out.println(username);
		System.out.println(password);
		if(list.size()>0){
			flag=true;
		}
		return flag;
	}
	
	//从数据库中取出学生信息
	public  List getAdmins() {

		return dao.retrieve("select * from admin", Admin.class);
	}
	/**
	 * delete admin
	 * @param adminId
	 * @return
	 */
	public  boolean deleteAdmin(String adminId) {
		boolean flag=false;
		int i=dao.delete("delete from admin where adminId=?", adminId);
		if (i>0) {
			flag=true;
		}
		return flag;
		
	}
	
	
	

}
