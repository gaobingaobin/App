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

public class CartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CartServlet() {
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
		 HttpSession session = request.getSession();
		 String username = (String) session.getAttribute("username");
		 int pid = Integer.parseInt(request.getParameter("pid"));
		 int count=  Integer.parseInt(request.getParameter("count"));	 
		try {
			Connection conn = DBHelper.getConnection();
			String sql = "select userid form user where username="+username;
			PreparedStatement ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			int userid = rs.getInt("userid");
			String sql1 = "insert into cart"+"(pid,userid,count)"+"values("+"'"+pid+"'"+","+"'"+userid+"'"+","+"'"+count+"'"+")";
			PreparedStatement ptmt1 = conn.prepareStatement(sql1);
			ptmt1.execute();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
