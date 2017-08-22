package com.an.dbcp;

import java.sql.Connection;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
//在构造其中配置链接池
public class Dbcp {
	private static Dbcp pool;
	private static BasicDataSource bdsrc;
	private Dbcp() {
		bdsrc=new BasicDataSource();
		bdsrc.setInitialSize(10);
		bdsrc.setMaxIdle(20);
		bdsrc.setMinIdle(5);
		bdsrc.setDriverClassName("com.mysql.jdbc.Driver");
		bdsrc.setUrl("jdbc:mysql://localhost:3306/data?userUnicode=ture&characterEncoding=utf8");
		bdsrc.setUsername("root");
		bdsrc.setPassword("root");
		
	}
	//单例模式获取实例的方法，获取实例时配置连接池；
	public static Dbcp getInstance (){
		if(null==pool) {
			synchronized (Dbcp.class) {
				if(null==pool) {
					pool=new Dbcp();
				}
			}
		}
		return pool;
	}
	//从连接池获取链接；
	public Connection getConnection() {
		Connection conn=null;
		try {
			conn=bdsrc.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
