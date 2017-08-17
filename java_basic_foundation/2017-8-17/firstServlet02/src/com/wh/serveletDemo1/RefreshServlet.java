package com.wh.serveletDemo1;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "RefreshServlet",urlPatterns = {"/RefreshServlet"},loadOnStartup = 1)
public class RefreshServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置5秒刷新
        response.setIntHeader("Refresh",2);
        Calendar calendar=Calendar.getInstance();
        Date date=calendar.getTime();


            DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime=format.format(date);
        PrintWriter printWriter=response.getWriter();
        printWriter.append("\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n")
                .append("<html> <head><title>刷新时间设置</title></head>\n")
                .append("<body><h2>当前时间为：\n")
                .append(currentTime)
                .append("</h2></body></html>");
        //printWriter.println("<h1>"+currentTime+"</h1>");



    }
}
