package com.wh.dbutils;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Dbutils {
    private static Dbutils pool;
//    private BasicDataSource dbsrc;
    private BasicDataSource dbsrc;
    private  Dbutils(){

        dbsrc=new BasicDataSource();
        dbsrc.setInitialSize(100);
        dbsrc.setMaxIdle(200);
        dbsrc.setMinIdle(20);
        dbsrc.setDriverClassName("com.mysql.jdbc.Driver");
        dbsrc.setUrl("jdbc:mysql:///apps?useUnicode=true&&characterEncoding=utf8");
        dbsrc.setUsername("root");
        dbsrc.setPassword("root");
    }
    //使用单例模式操作
    public static synchronized Dbutils getInstance(){
        if (null==pool)
            pool=new Dbutils();
        return  pool;
    }


    //从数据库中获得连接
    public Connection getConnection(){
        Connection connection=null;
        try {
            connection=dbsrc.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }
}
