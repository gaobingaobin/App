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
		ArrayList<UserCart> list = new ArrayList<UserCart>(); // ��Ʒ����
		try {
			conn = DBHelper.getConnection();
			String sql = "select pid,name,city,count,gross,picture from cart where username='"+username+"'"; // SQL���
			System.out.println(sql);
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
				list.add(usercart);// ��һ����Ʒ���뼯��
			}
			return list; // ���ؼ��ϡ�
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
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
	
		
	}


