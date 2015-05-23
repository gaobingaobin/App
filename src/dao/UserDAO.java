package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBHelper;

public class UserDAO {
	 public ResultSet SelectUser(String username,String password) {
		  ResultSet rs=null;
		  try {
			Connection conn = DBHelper.getConnection();
			String sql = "select username, password from user where username='"+username+"' and password='"+password+"'";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return rs;  
	  }
	 public void InsertUser(String username,String email,String password) {
		  
		  try {
			Connection conn = DBHelper.getConnection();
			String sql ="insert into user "+"(username,email,password)"+"values("+"'"+username+"'"+","+"'"+email+"'"+","+"'"+password+"'"+")";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.execute();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	
	  }
}
