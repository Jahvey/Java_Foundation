package com.wh.transaction01;


import java.sql.*;

/**
 * 测试事务
 */
public class TransactionTest01 {

    public static Connection Trans01(){
        Connection connection=null;
        try {
            String url="jdbc:mysql:///mydb2?useUnicode=true&characterEncoding=utf8";
            String username="root";
            String pwd="root";
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,username,pwd);
            if (connection!=null) System.out.println("success!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void Search01(Connection connection){
        if (connection!=null){
            try {
                PreparedStatement ps= connection.prepareStatement("select * from client");
                ResultSet rs=ps.executeQuery();
                while (rs.next()){
                    System.out.println("rs:..."+rs.getObject(3));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public static void Updata01(Connection connection){
        if (connection!=null){
            try {
                String sql1="UPDATE client set clientAmount = 19803 WHERE cardId=2";
                PreparedStatement ps= connection.prepareStatement(sql1);

                int count=ps.executeUpdate(sql1);
                if (count>0) System.out.println("update1 success!");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public  static void  Trans02(Connection connection){
        if (connection!=null){
            try {
                connection.setAutoCommit(false);
                String sql="select * from client";
                String sql1="UPDATE client set clientAmount = 19811 WHERE cardId=2";
                PreparedStatement ps= connection.prepareStatement(sql1);


                int count=ps.executeUpdate(sql1);
                if (count>0) System.out.println("update1  success!");
               // System.out.println(ps.executeQuery("SELECT  * FROM  client WHERE "+ps.executeQuery(sql).getMetaData().getColumnName(1)+"=2"));
                String sql2="UPDATE client set clientAmount = 4983 WHERE clientName='tim'";
                PreparedStatement ps1= connection.prepareStatement(sql1);

                int count1=ps1.executeUpdate(sql2);
                if (count1>0) System.out.println("update2 success!");


                //显示声明是否提交
                connection.commit();
            } catch (Exception e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        Search01(Trans01());
        //Trans02(Trans01());
        //Updata01(Trans01());
    }
}
