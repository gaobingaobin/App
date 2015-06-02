package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDAO;
import dao.UserCartDAO;

public class MessageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MessageServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ResultSet rs = null;
		HttpSession session = request.getSession();
		UserCartDAO usercart = new UserCartDAO();
		String username = (String) session.getAttribute("username");
		if(username!=null){
		rs = usercart.SelectSql(username);
		try {
			rs.next();
			int userid = rs.getInt("userid");
			System.out.println(userid);
			int pid = Integer.parseInt(request.getParameter("pid"));
			String message = request.getParameter("message");
			
			MessageDAO  messagedao =new MessageDAO();
			messagedao.InsertLevMessage(pid, userid, message, username);
			System.out.println(message);
			response.sendRedirect(request.getContextPath()+"/details.jsp");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else{
			
			response.sendRedirect(request.getContextPath()+"/NoLogin.jsp");
			
		}
		
		

		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
