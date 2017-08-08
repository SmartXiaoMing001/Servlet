package com.cjk.domin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cjk.domain.User;

public class UserService {
	
	private Connection ct = null;
	private  PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * @param user
	 * @return
	 * 
	 * Pending User is Correct!
	 */
	public boolean checkUser(User user){
		
		boolean result = false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/root", "root", "123456");
			ps = ct.prepareStatement("select * from users where id=? and password=?");
			ps.setObject(1, user.getId());
			ps.setObject(2, user.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					ps.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try{
					ps.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}