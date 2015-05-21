package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBHelper;

public class DeleteUserGoods extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteUserGoods() {
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
		 
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("username");
		int pid = Integer.parseInt(request.getParameter("pid"));
		try {
			Connection conn = DBHelper.getConnection();
			if(conn==null)
			{
				System.out.println("��ȡ����ʧ�ܣ�");
			}
			String sql = "delete from cart where username='"+username+"' and pid="+pid+"";
			System.out.println(sql);
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.execute();
		 response.sendRedirect(request.getContextPath()+"/UserCart.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
