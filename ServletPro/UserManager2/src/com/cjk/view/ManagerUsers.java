package com.cjk.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerUsers extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection ct = null;
	private PreparedStatement ps = null;  
	private ResultSet rs = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=utf-8"); //没有会出来乱码
		PrintWriter out = resp.getWriter();
		out.println("<h1>管理用户</h1>");
		
		//分页！！！
		int pageNow = 1;  
		int pageSize = 3;  
		int pageCount = 1; 
		int rowCount = 1; //total record, from database
		
		pageCount = (rowCount - 1) / pageSize + 1;
		
		/*
		 * (select *from (select t.*,rownum rn from " + "(select * from users order by id) t where rownum<="+pageSize*pageNow+") where rn>="+(pageSize*(pageNow-1)+1));
		 * 
		 * */
		try{
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/root", "root", "123456");
			
			//查询多少条数据
			ps = ct.prepareStatement("select * from users");
			rs = ps.executeQuery();
			
			out.println("<table border=1 width =500px>");
			out.println("<tr><th>id</th><th>用户名</th><th>email</th><th>级别</th></tr>");
			while(rs.next()){
				out.println("<tr><td>"+rs.getInt(1)+
						"</td><td>"+rs.getString(2)+
						"</td><td>"+rs.getString(3)+
						"</td><td>"+rs.getInt(4)+
						"</td></tr>");
			}
			out.println("</table>");
			
		} catch (Exception e){
			e.printStackTrace(); 
		} finally {
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
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
