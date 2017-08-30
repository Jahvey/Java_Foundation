package com.adonai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adonai.service.AdminService;
import com.adonai.service.myService;

/**
 * Servlet implementation class DeleteAdminServlet
 */
@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	
       
	private AdminService service = new AdminService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminServlet() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId=request.getParameter("adminId");
		
		PrintWriter pw=response.getWriter();
		if (service.deleteAdmin(adminId)) {
			pw.write("{\"msg\":\"ok\"}");
		}else {
			pw.write("{\"msg\":\"error\"}");
		}
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
