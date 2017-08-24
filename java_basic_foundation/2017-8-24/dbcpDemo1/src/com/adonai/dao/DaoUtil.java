package com.adonai.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adonai.dbcp.Dbcp;

public class DaoUtil {
	/**
	 * 增删改的实现方法
	 * @param sql 需要执行的sql语句
	 * @param objects sql语句的参数
	 * @return 受影响的行
	 * crud ->create增加 ,retrieve 检索，查询,update更新,delete删除
	 */
	
	public static int excuteCud(String sql,Object...objects){
		int rows = 0;
		//第一步：实例化连接池
		Dbcp pool = Dbcp.getInstance();
		//第二步：从连接池中获取链接
		Connection conn = pool.getConnetion();
		
		PreparedStatement ps = null;
		
		try {
			//第三部：获取sql参数化对象,获取的同时预编译sql语句
			ps = conn.prepareStatement(sql);
			for(int i = 0;i<objects.length;i++){
				//填充占位符？
				ps.setObject(i+1, objects[i]);
			}
			//执行
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn(conn,ps,null);
		return rows;
	}
	/**
	 * 通用查询的实现方法
	 * @param sql sql语句
	 * @param clazz 结果集合中的存的对象的运行时类 比如查询的结果是学生，则此参数为Student.class
	 * @param objects 查询参数
	 * @return 查询的结果：存实体类的集合
	 */
	public static List excuteQuery(String sql,Class clazz,Object...objects){
		List list = new ArrayList();
		Dbcp pool = Dbcp.getInstance();
		Connection conn = pool.getConnetion();
		
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				ps.setObject(i+1, objects[i]);
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			//通过ResultSetMetaData对象获取查询结果集的记录的列的数量
			//因为要通过列的下标来获取下标对应的列的值
			int columnCount = rsmd.getColumnCount();
			//rs.next就是遍历结果集
			while( rs.next() ){
				//通过反射获取对象
				Object obj = clazz.newInstance();
				//遍历结果集每一条记录的下标，将下标对应的列的值set进对象中
				for(int i = 1;i<=columnCount;i++){
					//通过列的下标获取下标所对应的列的值
					Object value = rs.getObject(i);
					//通过下标获取列的名字，因为Field对象的创建必须要有列的名字(即columnLable，以下为fieldName)
					String fieldName = rsmd.getColumnName(i);
//					Object value = rs.getObject(fieldName);
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(obj, value);//sutdent.setName("owen");
					
					
				}
				list.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConn(conn,ps,rs);
		return list;
	}
	//关闭各种流和连接的方法
	public static void closeConn(Connection conn,PreparedStatement ps,ResultSet rs){
		if(null!=rs){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null==ps){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
