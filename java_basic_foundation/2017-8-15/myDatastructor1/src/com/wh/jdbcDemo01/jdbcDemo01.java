package com.wh.jdbcDemo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class jdbcDemo01 {

    private static Connection conn;
    private static String user="root";
    static String password="root";
    //url :统一资源定位符
    static String url="jdbc:mysql://localhost:3306/mydb1?useUnicode=true&characterEncoding=utf8";

//    static{
//
//
//        try {
//            //显示加载数据库的驱动程序
//            Class.forName("com.mysql.jdbc.Driver");
//            /***
//             * 数据库的url 的组成：协议jdbc,只要是连接java的协议的名称都是jdbc
//             * 子协议，mysql连接的具体的数据库
//             * 资源：ip+数据库名：比如，本机叫localhost 127.0.0.1
//             *数据库的端口：3306
//             *
//             *
//             */
//
//            conn= DriverManager.getConnection(url,user,password);
//
//            String name;
//            if(!conn.isClosed())
//                System.out.println("Succeeded connecting to the Database!");
//            // statement用来执行SQL语句
//            Statement statement = conn.createStatement();
//            // 要执行的SQL语句
//            String sql = "select * from student";
//            // 结果集
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next())  {
//                // 选择Name这列数据
//                name = rs.getString("stu_name");
//                // 输出结果
//                System.out.println(rs.getString("stu_address") + "\t" + name);
//            }
//            rs.close();
//            conn.close();
//
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }

    private static void ShowData(List list){

        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i));

    }

    private static List<student> getAll(){
        List<student> list=new LinkedList<>();

        try {

           // conn= DriverManager.getConnection(url,user,password);
            conn=getConnections();
            student student=null;
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            String sql = "select * from student";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())  {
                student=new student();
                // 选择Name这列数据
                student.setName( rs.getString("stu_name"));
                student.setId(rs.getInt("stu_id"));
                student.setAge(rs.getInt("stu_age"));
                student.setGender(rs.getString("stu_gender"));
                student.setDate(rs.getDate("stu_date"));
                student.setAddress(rs.getString("stu_address"));
                // 输出结果
                list.add(student);
                //手动释放student所占堆的内存块
                student=null;

                //System.out.println(rs.getString("stu_address") + "\t" + name);
            }
            ShowData(list);
            rs.close();
            conn.close();




        } catch (Exception e) {
            e.printStackTrace();
        }return  list;
    }

    private static Connection getConnections(){
        try {
    if (conn!=null)
        return  conn;
            conn= DriverManager.getConnection(url,user,password);
        }catch (Exception e){

        }
        return conn;

    }

    public static void main(String[] args) {
        //System.out.println(getAll());
        getAll();

    }


}
