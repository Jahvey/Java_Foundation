package com.wh.serveletDemo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getFilterTestServlet",urlPatterns = {"/getFilterTestServlet"},loadOnStartup = 1)
public class getFilterTestServlet extends HttpServlet {

    public void Write(HttpServletRequest request, HttpServletResponse response){

        //servlet中用于取出Html中的元素（标签比如input）,中属性为username的值
        String username=request.getParameter("username");
        //获取username后数据库字段中用于查询name中为username的值


        System.out.println(username);
        //System.out.println(new String(username.getBytes("ISO-8859-1"),"utf-8"));//输出正常：王振华

        try {
            PrintWriter out = response.getWriter();

            out.println("<h1>Hello,"+username+"</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Write(request,response);
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Write(request,response);
        //doPost(request,response);
    }
}
