package com.wh.transaction01;


import java.sql.*;

public class savePoint01 {

    public static void Transaction01(Connection connection){
        if (connection!=null){

            String sql="";
            try {
                //打开事务
                connection.setAutoCommit(false);
                sql="update client set clientAmount = -20 WHERE  cardId=3";

                PreparedStatement ps=connection.prepareStatement(sql);
                ps.executeUpdate();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }finally {
                try {
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void Transcation02(Connection connection){
        if (connection!=null){

            String sql="";
            Savepoint savepoint=null;
            try {
                //打开事务
                connection.setAutoCommit(false);
                sql="update client set clientAmount = -20 WHERE  cardId=3";
                //PreparedStatement ps=connection.prepareStatement(sql);
                Statement ps=connection.createStatement();
                ps.executeUpdate(sql);
                connection.setSavepoint("savepoint");
                sql="update client set clientAmount=300000 WHERE  clientName='tim'";

                ps.executeUpdate(sql);
                sql="update client set clientAmount=-999 WHERE  clientName1='owen'";
                ps.executeUpdate(sql);
                connection.commit();

            } catch (SQLException e) {
                try {
                    if (null!=savepoint){

                        connection.rollback(savepoint);
                        System.out.println("save-point has been  execute!");
                        connection.commit();
                    }else {
                        connection.rollback();
                        System.out.println("all transcation rollback");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }

    }

    public static void Insert01(Connection connection){
        if (connection!=null){
            String sql="";
            try {
                //打开事务
                connection.setAutoCommit(false);
                sql="insert into client values(?,?,?)";

                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setObject(1,111);
                ps.setObject(2,"中国惊奇先生");
                ps.setObject(3,111);
                ps.executeUpdate();
                System.out.println("Insert success!");

            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }finally {
                try {
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql:///mydb2?useUnicode=true&characterEnconding=utf8";
            String username="root";
            String pwd="root";
            connection= DriverManager.getConnection(url,username,pwd);
            if (connection!=null) System.out.println("regist driver success!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  connection;
    }
    public static void main(String[] args) {
        //Transaction01(getConnection());
        //Insert01(getConnection());
        Transcation02(getConnection());
    }
}
