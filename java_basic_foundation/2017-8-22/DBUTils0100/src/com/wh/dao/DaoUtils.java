package com.wh.dao;


import com.wh.dbutils.Dbutils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoUtils {
    /***
     *CRUD增删改的实现
     * @param sql 需要执行的sql语句
     * @param objects 需要填充的sql的参数
     * @return 受影响的行
             */
    public static int executeCud(String sql,Object...objects){
        int rows=0;
//实例化连接池
        Dbutils dbutils=Dbutils.getInstance();
        //从数据库连接池中取出数据
        Connection connection=dbutils.getConnection();

        try {
            //获取sql参数化对象,获取的同时预编译sql语句
            PreparedStatement ps=connection.prepareStatement(sql);
            for(int i=1;i<=objects.length;i++){
                //填充占位符？
                ps.setObject(i,objects[i-1]);
            }
            rows=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return rows;
    }

    public static List  executeQuery(String sql,Class clazz,Object...objects){
        List list=new ArrayList();
        Dbutils pool=Dbutils.getInstance();
        Connection connection=pool.getConnection();
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement(sql);
            for (int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }

            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            int columNum=rsmd.getColumnCount();
            while (rs.next()){
                //通过反射获取对象
                Object obj=clazz.getInterfaces();
                //遍历列的下标，获取下标对应对的列的值
                for (int i=1;i<=columNum;i++){
                    String Fieldname=rsmd.getColumnName(i);
                    Object value=rs.getObject(i);
//                    Object value=rs.getObject(Fieldname);和上面的代码执行的结果一样
                    Field field=clazz.getDeclaredField(Fieldname);
                    field.set(obj,value);//studnet.setName("adonai")
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }




}
