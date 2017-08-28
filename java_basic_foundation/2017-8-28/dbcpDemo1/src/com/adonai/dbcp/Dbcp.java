package com.adonai.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class Dbcp {
	
	private static Dbcp pool;
	private static BasicDataSource bdsrc;
	//在构造器中配置连接池
	private Dbcp(){
		bdsrc = new BasicDataSource();
		bdsrc.setInitialSize(10);
		bdsrc.setMaxIdle(20);
		bdsrc.setMinIdle(5);
		bdsrc.setDriverClassName("com.mysql.jdbc.Driver");
		bdsrc.setUrl("jdbc:mysql://localhost:3306/mydb2?useUnicode=true&characterEncoding=utf8");
		bdsrc.setUsername("root");
		bdsrc.setPassword("root");	
	}
	//单例模式获取实例的方法，获取实例时配置连接池
	public static Dbcp getInstance(){
		if(null==pool){
			synchronized (Dbcp.class) {
				if(null==pool){
					pool = new Dbcp();
				}
			}
		}
		return pool;
	}
	//从连接池中获取链接
	public Connection getConnetion(){
		Connection conn=null;
		try {
			conn = bdsrc.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
