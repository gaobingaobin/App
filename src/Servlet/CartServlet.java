package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemsDAO;
import dao.UserCartDAO;

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
		 ResultSet rs1 = null;
		 ResultSet rs2 = null;
	     String name=null;
	     String city=null;
	     int gross=0; //总价格
	     String picture=null;
		 HttpSession session = request.getSession();
		 String username = (String) session.getAttribute("username");
		 int pid = Integer.parseInt(request.getParameter("pid"));
		 int count=  Integer.parseInt(request.getParameter("count"));	
		 if(username==null){
			 response.sendRedirect(request.getContextPath()+"/NoLogin.jsp");
		 }
		try {
			UserCartDAO usercart = new UserCartDAO();
			rs = usercart.SelectSql(username);
			rs.next();
			int userid = rs.getInt("userid");
			Connection conn = DBHelper.getConnection();
			ItemsDAO itemdao = new  ItemsDAO();
			rs1 = itemdao.SelectItemsPid(pid);	
			while(rs1.next()){
				name = rs1.getString("name");
				city = rs1.getString("city");
				gross = rs1.getInt("price")*count;
				picture = rs1.getString("picture");
			}
		/*	
		 * 
		 * 为了防止显示两条相同产品的购买记录，存入数据库对数据进行处理一下， 数据库有此产品进行对数量和总价格的更新操作， 没有则进行插入操作
			*/
			rs2 = usercart.Selectcart(username, pid);
			if(rs2.next())
			{   
				int count1 = rs2.getInt("count");	
				int gross1 = rs2.getInt("gross");
				int count2 =count+count1;
				int gross2 = (gross1/count1)*count2;
				usercart.Updateusercart(count2, gross2, pid, username);
				response.sendRedirect(request.getContextPath()+"/CartSuccess.jsp");
			}
			else{
			
			
			usercart.Insertusercart(pid, userid, count, name, city, picture, gross, username);
			response.sendRedirect(request.getContextPath()+"/CartSuccess.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
					rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
