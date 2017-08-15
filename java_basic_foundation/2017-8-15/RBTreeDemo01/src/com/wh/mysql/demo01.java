package com.wh.mysql;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class demo01 {

    public static Connection getConnection(){

        String name="root";
        String pass="root";
        String url="jdbc:mysql:///mydb1?useUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(url, name, pass);
            //return connection;
        }catch (Exception e){

        }


        return  connection;


    }

    public static void show(List list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static List<Student> Search01(Connection connection){

        List<Student>list=new  LinkedList<>();
        Student student=null;
        try {
            if (connection==null)connection=getConnection();
            PreparedStatement ppt= connection.prepareStatement("SELECT  * FROM student where stu_address=?");
            ppt.setString(1,"内江");//query的顺序

            ResultSet rs=ppt.executeQuery();
            while (rs.next()){
               // System.out.println(rs.getString(1));
            student=new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setAge(rs.getInt(3));
            student.setDate(rs.getDate(4));
            student.setGender(rs.getString(5));
            student.setAddress(rs.getString(6));
            list.add(student);
            student=null;

        }
    } catch (SQLException e) {
        e.printStackTrace();
        }
        return list;
    }

    public static List<Student> Search02(Connection connection){

    List<Student> list=new LinkedList<>();
        Student student=null;
        try {
            if (connection==null)connection=getConnection();
            PreparedStatement ppt= connection.prepareStatement("SELECT * from student where stu_name   REGEXP  '^[jt][a-zA-Z]{0,}(im)$'");
           // ppt.setString(1,"内江");//query的顺序

            ResultSet rs=ppt.executeQuery();
            while (rs.next()){
                // System.out.println(rs.getString(1));
                student=new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
                student.setDate(rs.getDate(4));
                student.setGender(rs.getString(5));
                student.setAddress(rs.getString(6));
                list.add(student);
                student=null;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;




    }






    public static void main(String[] args) {
        //getConnection();
        show(Search02(getConnection()));

    }
}
