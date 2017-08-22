package com.an.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import com.an.dbcp.Dbcp;

public class DaoUtil {
	/**
	 * 实现曾删改的方法
	 * @param sql   需要执行的sql 的语句
	 * @param objects sql语句的参数
	 * @return  受影响的行
	 */
	public static int excuteCud(String sql, Object...objects) {
		int rows =0;
		//第一步；实例化链接池
		Dbcp pool=Dbcp.getInstance();
		//第二步；从连接池获取链接
		Connection conn=pool.getConnection();

		PreparedStatement ps=null;

		try {
			//第三步；获取sql参数化对象,获取的同时预编译sql语句；
			ps=conn.prepareStatement(sql);
			for(int i=0; i<objects.length;i++) {
				//填充站位符？
				ps.setObject(i+1, objects[i]);
			}
			//执行
			rows=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	public static  List excuteQuery(String sql,Class clazz,Object...objects) {
		List list=new ArrayList<>();
		Dbcp pool=Dbcp.getInstance();
		Connection conn=pool.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0; i<objects.length;i++) {
				ps.setObject(i+1, objects[i]);
			}
			ResultSet rs=ps.executeQuery();
			// 通过ResultSetMetaData对象获取查询结果集的记录的列的数量
			ResultSetMetaData rsmd=rs.getMetaData();
			
			//因为要通过列的下标来获取对应列的值；
			int columCount=rsmd.getColumnCount();
			//rs.naxt()就是遍历结果集；
			while(rs.next()) {
				//通过反射获取对象
				Object obj =clazz.newInstance();
				//遍历结果集每一条记录的下标，将下标对应的列的值set进对象中；
				for(int i=0;i<columCount;i++) {	
					//通过列的下标获取下标所对应的值
					Object value=rs.getObject(i);
					//通过下标获取列的名字，应为Feild对象创建必须要有列的名字（即columnLable,）
					String fieldname= rsmd.getColumnName(i);
				//Object value= rs.getObject(fieldname);
					Field field=clazz.getDeclaredField(fieldname);
					field.set(obj,value);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
