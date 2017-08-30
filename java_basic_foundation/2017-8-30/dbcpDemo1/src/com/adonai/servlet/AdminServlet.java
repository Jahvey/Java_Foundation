package com.adonai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.UserDatabaseRealm;

import com.adonai.bean.Admin;
import com.adonai.bean.Student;
import com.adonai.service.AdminService;
import com.adonai.service.myService;
@WebServlet(urlPatterns="/AdminServlet")
public class AdminServlet extends HttpServlet{



	private AdminService service=new AdminService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session=req.getSession();

		session.setAttribute("username", name);
		session.setAttribute("password", password);
		Cookie [] cks=req.getCookies();
		for (Cookie cookie : cks) {
			System.out.println("name:"+cookie.getName());
			System.out.println("value:"+cookie.getValue());
			resp.addCookie(cookie);
			
		}
		System.out.println(session.getId());
		
		boolean existed = service.existed(name, password);
		if(existed){
			
			List<Admin> admins=service.getAdmins();
			
			//将键值存储在数据库中，以便jsp可以取出数据，
			//jsp取数据可以对应相应的关键字取出，比如下方的"students"
			//req.setAttribute("admins", admins);
			session.setAttribute("admins", admins);
			
			//转发
			//req.getRequestDispatcher("admin.jsp").forward(req, resp);
			resp.sendRedirect("admin.jsp");
		}else{
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("AdminServlet被初始化了......");
	}

	@Override
	public void destroy() {
		System.out.println("AdminServlet被销毁了.....");
	}	
}
