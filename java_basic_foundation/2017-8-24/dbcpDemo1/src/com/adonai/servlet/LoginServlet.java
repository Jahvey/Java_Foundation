package com.adonai.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adonai.service.myService;
//注解式的注册
/*servlet的生命周期：3个->init()初始化，即产生这个类的实例，默认是在第一次被访问时执行一次且只执行一次
 * ->service()服务，每次访问时被容器调用；->destroy()servlet被销毁的时候被容器调用
 */
//servlet 在web项目中起到controller的作用，接收请求，调用，返回数据
@WebServlet(urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 3511893889739545303L;
	private myService service = new myService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean existed = service.existed(username, password);
		if(existed){
			//转发
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet被初始化了......");
	}

	@Override
	public void destroy() {
		System.out.println("LoginServlet被销毁了.....");
	}	
	
}
