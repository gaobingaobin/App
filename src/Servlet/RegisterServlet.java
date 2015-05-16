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
			throws ServletException, IOException {
	
		 request.setCharacterEncoding("utf-8");
		 String username = request.getParameter("username");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 String password1 = request.getParameter("password1");
		 
		try {
			Connection conn = DBHelper.getConnection();
			if(conn==null){
				System.out.println("����ʧ��");
			}
			
			String sql ="insert into user "+"(username,email,password)"+"values("+"'"+username+"'"+","+"'"+email+"'"+","+"'"+password+"'"+")";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			System.out.println(sql);
		    ptmt.execute(); 
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		   
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}
	 
	
	public void init() throws ServletException {


}
}