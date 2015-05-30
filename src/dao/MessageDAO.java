package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entity.Levmessage;
import entity.UserCart;

import util.DBHelper;

public class MessageDAO {
	public void InsertLevMessage(int pid,int userid, String message,String username){
		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into levmessage"+"(pid,userid,message,username)"+"values("+pid+","+userid+","+"'"+message+"'"+","+"'"+username+"'"+")";
			ptmt = conn.prepareStatement(sql);
			ptmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ptmt!=null){
				try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ptmt = null;
			}
		}
		
		
	}
	


public ArrayList<Levmessage> getAllMessagePid(int pid){
	ResultSet rs = null;
	PreparedStatement ptmt = null;
	Connection conn = null;
	ArrayList<Levmessage> list = new ArrayList<Levmessage>();//某个商品评价集合
	
	try {
		conn = DBHelper.getConnection();
		String sql = "select pid,userid,mdate,message,username from Levmessage where pid="+pid+"";
		ptmt = conn.prepareStatement(sql);
		rs = ptmt.executeQuery();
		while(rs.next()){
			Levmessage message = new Levmessage();
			message.setPid(rs.getInt("pid"));
			message.setUserid(rs.getInt("userid"));
			message.setMdate(rs.getDate("mdate"));
			message.setMessage(rs.getString("message"));
			message.setUsername(rs.getString("username"));
			list.add(message);		
		}
		return list;	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally{
		if(rs!= null){
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(ptmt!=null){
			try {
				ptmt.close();
				ptmt = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	
}
}
 