package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Carts;


import util.DBHelper;

public class UserCart extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserCart() {
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

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			 ResultSet rs = null;
			 ResultSet rs1 = null;
			 HttpSession session = request.getSession();
			 String username = (String) session.getAttribute("username");
			 ArrayList<Carts> list = new ArrayList<Carts>();
			 try {
				Connection conn = DBHelper.getConnection();
				String sql = "selcet userid form cart where username="+username;
				PreparedStatement ptmt = conn.prepareStatement(sql);
				rs = ptmt.executeQuery();
				int userid = rs.getInt("userid");
				String sql1 = "select pid form cart where userid="+userid;
				PreparedStatement ptmt1 = conn.prepareStatement(sql1);
				rs1 = ptmt.executeQuery();
				while(rs1.next()){
					Carts carts = new Carts();
					carts.setPid(rs1.getInt("pid"));
					list.add(carts);
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
