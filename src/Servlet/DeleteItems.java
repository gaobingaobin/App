package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;

import util.DBHelper;

public class DeleteItems extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteItems() {
		super();
	}

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
		int pid = Integer.parseInt(request.getParameter("pid"));
		ItemsDAO itemdao = new  ItemsDAO();
		itemdao.DeleteItems(pid); //调用删除商品函数
			
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
