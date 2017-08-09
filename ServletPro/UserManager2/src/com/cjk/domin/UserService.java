package com.cjk.domin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cjk.domain.User;
import com.cjk.util.SQLHelper;

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
	
	public boolean delUser(String id){
		
		boolean result = false;
		
		String sql = "delete from users where id=?";
		String parameters[] = {id};
		try{
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/root", "root", "123456");
			ps = ct.prepareStatement(sql);
			for (int i=0;i<parameters.length;i++){
				ps.setObject(++i, parameters[--i]);
			}
			if(ps.executeUpdate() > 0){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			SQLHelper.close(rs, ps, ct);
		}
		return result;
	}
	
	public boolean updateId(String id) {
		boolean result = false;
		String userName = "大鹏";
		String email = "cjk123@163.com";
		String parameters[] = {userName,email,id};
	    String sql = "update users set userName=?,email=? where id=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/root?characterEncoding=utf-8", "root", "123456");
			ps = ct.prepareStatement(sql);
			for (int i=0;i<parameters.length;i++){
				ps.setObject(++i, parameters[--i]);
			}
			if(ps.executeUpdate() > 0){
				result = true;
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally{
			SQLHelper.close(rs, ps, ct);
		}
		return result;
	}
}
