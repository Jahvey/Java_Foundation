package com.wh.serverletDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet01")
public class FirstServlet01 extends HttpServlet {
    @Override
    public void destroy() {
        System.out.println("servlet被销毁了......");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet被初始化了......");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("Hello Servlet");
        System.out.println("This Is My First Servlet Example!");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String info = request.getParameter("info");
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("<h1>Hello,王震华</h1>");
        out.println("info = "+info);
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
