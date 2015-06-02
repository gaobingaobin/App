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
import util.PasswordMD5;

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
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 PasswordMD5 passwordmd5 = new PasswordMD5();
		 UserDAO userdao = new UserDAO();
		 String username = request.getParameter("username");
		 
		 
		 String email = request.getParameter("email");
		 String Initialpassword = request.getParameter("password");
		 String Initialpassword1 = request.getParameter("password1");
		 if(Initialpassword.equals(Initialpassword1)&&username!=null&&Initialpassword!=null){ 
			byte[] bytepassword = Initialpassword.getBytes();
			String password = passwordmd5.getMD5(bytepassword);
		    userdao.InsertUser(username, email, password);
		    response.sendRedirect(request.getContextPath()+"/index.jsp");	 
		 }
		 else{
			 response.sendRedirect(request.getContextPath()+"/PasswordError.jsp");
			
		 }
				 
	
		
		   
	
				

	}
	 
	
	public void init() throws ServletException {


}
}