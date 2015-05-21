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
	     int gross=0; //�ܼ۸�
	     String picture=null;
		 HttpSession session = request.getSession();
		 String username = (String) session.getAttribute("username");
		 int pid = Integer.parseInt(request.getParameter("pid"));
		 int count=  Integer.parseInt(request.getParameter("count"));	
		 if(username==null){
			 response.sendRedirect(request.getContextPath()+"/NoLogin.jsp");
		 }
		try {
			Connection conn = DBHelper.getConnection();
			String sql = "select userid from user where username='"+username+"'";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			rs.next();
			int userid = rs.getInt("userid");
			String sql1 = "select name,city,price,picture from items where pid="+pid+"";
			
			PreparedStatement ptmt1 = conn.prepareStatement(sql1);
			rs1=ptmt1.executeQuery();
			
			while(rs1.next()){
				name = rs1.getString("name");
				city = rs1.getString("city");
				gross = rs1.getInt("price")*count;
				picture = rs1.getString("picture");
			}
		/*	
		 * 
		 * Ϊ�˷�ֹ��ʾ������ͬ��Ʒ�Ĺ����¼���������ݿ�����ݽ��д���һ�£� ���ݿ��д˲�Ʒ���ж��������ܼ۸�ĸ��²����� û������в������
			*/
			String sql2 ="select count,gross from cart where username='"+username+"' and pid="+pid+"";
			System.out.println(sql2);
			PreparedStatement ptmt2 = conn.prepareStatement(sql2);
			rs2=ptmt2.executeQuery();
			
			if(rs2.next())
			{   
				int count1 = rs2.getInt("count");
				
				int gross1 = rs2.getInt("gross");
				int count2 =count+count1;
				int gross2 = (gross1/count1)*count2;
				String sql4 = "update cart set count="+count2+","+"gross="+gross2+"  where username='"+username+"' and pid="+pid+"";
				System.out.println(sql4);
				PreparedStatement ptmt4 = conn.prepareStatement(sql4);
				ptmt4.executeUpdate();	
				response.sendRedirect(request.getContextPath()+"/CartSuccess.jsp");
			}
			else{
			
			String sql3 = "insert into cart"+"(pid,userid,count,name,city,picture,gross,username)"+"values" +
					"("+pid+","+userid+","+count+","+"'"+name+"'"+","+"'"+city+"'"+","+"'"+picture+"'"+","+gross+","+
					"'"+username+"'"+")";
			
			PreparedStatement ptmt3 = conn.prepareStatement(sql3);
			ptmt3.execute();
			System.out.println(sql3);
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
