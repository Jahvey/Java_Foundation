package com.wh.serveletDemo1;


import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//name = "SearchServlet",
@WebServlet(name = "SearchServlet",urlPatterns={"/SearchServlet"})
public class SearchServlet extends HttpServlet {


    private Connection getConnection()throws Exception{

         Class.forName("com.mysql.jdbc.Driver");//class not found
        //必须要按照如下的方式写
        //Driver driver = new com.mysql.jdbc.Driver();
        //DriverManager.registerDriver(driver);
        Connection connection=null;
         String name="root";
         String pass="root";
         String url="jdbc:mysql://localhost:3306/mydb1?useUnicode=true&characterEncoding=utf-8";
         connection= DriverManager.getConnection(url,name,pass);
         return  connection;

    }

    public boolean CheckLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
            Connection connection=getConnection();
        PreparedStatement ps=connection.prepareStatement("SELECT  * FROM  user WHERE  username=? and password=?");
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();

        if (rs!=null){
            System.out.println("Login success....");
            WriteInfo(request,response);
            return true;
        }else {
            System.out.println("Login failure....");
            return false;
        }


    }

    public void WriteInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String username=request.getParameter("username");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("<h1>Hello,"+username+",Welcome to Login !!</h1>");

    }

    @Override
    public void init() throws ServletException {
        System.out.println("Searching Servlet init complete!!!!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            CheckLogin(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
