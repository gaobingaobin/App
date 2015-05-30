package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

import entity.Users;

import util.DBHelper;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException ,NumberFormatException {
	
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 PrintWriter out = response.getWriter();
		 String username = request.getParameter("username");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 String password1 = request.getParameter("password1");
		 if(password.equals(password1)&&username!=null&&password!=null){
			  
		    UserDAO userdao = new UserDAO();
		    userdao.InsertUser(username, email, password);
		    response.sendRedirect(request.getContextPath()+"/index.jsp");	 
		 }
		 else{
			 out.print("ÃÜÂë²»Ò»ÖÂ£¡");
			
		 }
				 
	
		
		   
	
				

	}
	 
	
	public void init() throws ServletException {


}
}