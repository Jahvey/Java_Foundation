package com.wh.serveletDemo1;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//name = "LoginServlet"
@WebServlet(loadOnStartup=1,urlPatterns={"/LoginServlet"})//annotation
public class LoginServlet extends HttpServlet {


    public void Write(HttpServletRequest request,HttpServletResponse response){

        //servlet中用于取出Html中的元素（标签比如input）,中属性为username的值
        String username=request.getParameter("username");
        //获取username后数据库字段中用于查询name中为username的值

        try {
            System.out.println(new String(username.getBytes("ISO-8859-1"),"utf-8"));//输出正常：王振华
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            //response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
           // request.setCharacterEncoding("UTF-8");
            String info = request.getParameter("info");
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            out.println("<h1>Hello,"+username+"</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void init() throws ServletException {
        System.out.println("Login servlet 被初始化了.....");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Write(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPut(request,response);
    }
}
