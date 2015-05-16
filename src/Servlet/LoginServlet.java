package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBHelper;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 ResultSet rs = null;
		 boolean a;
		 response.setCharacterEncoding("utf-8");
		 //PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Connection conn = DBHelper.getConnection();
			
			if(conn==null){
				System.out.println("¡¥Ω” ß∞‹");
			}	
			String sql = "select username, password from user where username='"+username+"' and password='"+password+"'";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
		
			if( rs.next()){
				HttpSession session = request.getSession();
				session.setAttribute("username",username);
    			session.setAttribute("password",password);
    			
    			response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			else{
			
				response.sendRedirect(request.getContextPath()+"/LoginFail.jsp");
			}
				
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
