package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import util.DBHelper;

import entity.Carts;
import entity.Items;
import entity.UserCart;

public class UserCartDAO {
	//
	public ArrayList<UserCart> getUserCartByUserName(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<UserCart> list = new ArrayList<UserCart>(); // 商品集合
		try {
			conn = DBHelper.getConnection();
			String sql = "select pid,name,city,count,gross,picture from cart where username='"+username+"'"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserCart usercart = new UserCart();
				usercart.setPid(rs.getInt("pid"));
				usercart.setName(rs.getString("name"));
				usercart.setCity(rs.getString("city"));
				usercart.setCount(rs.getInt("count"));
				usercart.setGross(rs.getInt("gross"));
				usercart.setPicture(rs.getString("picture"));
				list.add(usercart);// 把一个商品加入集合
			}
			return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		}
	public ResultSet SelectSql(String username){
		 ResultSet rs = null;
		try {
		
			Connection conn = DBHelper.getConnection();
			String sql = "select userid from user where username='"+username+"'";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	 public ResultSet Selectcart(String username, int pid) {
		  ResultSet rs=null;
		  try {
			Connection conn = DBHelper.getConnection();
			String sql = "select count,gross from cart where username='"+username+"' and pid="+pid+"";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return rs;  
	  }
	 public void Updateusercart(int count,int gross, int pid,String username){
		 try {
				Connection conn = DBHelper.getConnection();
				String sql = "update cart set count="+count+","+"gross="+gross+" " +
						" where username='"+username+"' and pid="+pid+"";
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 public void Insertusercart(int pid, int userid, int count,String name,String city,String picture,int gross,String username){
		 try {
				Connection conn = DBHelper.getConnection();
				String sql = "insert into cart"+"(pid,userid,count,name,city,picture,gross,username)"+"values" +
						"("+pid+","+userid+","+count+","+"'"+name+"'"+","+"'"+city+"'"+","+"'"+picture+"'"+","+gross+","+
						"'"+username+"'"+")";
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.execute();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 public void  Deletecart(String username, int pid){
		 try {
				Connection conn = DBHelper.getConnection();
				String sql = "delete from cart where username='"+username+"' and pid="+pid+"";
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.execute();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
		
	}


