package com.cjk.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjk.domain.User;
import com.cjk.util.DBHelper;
import com.cjk.util.MyTools;


public class LoginClServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	static String sql = null;  
//    static DBHelper db1 = null;  
//    static ResultSet ret = null; 
	
	private Connection ct = null;
	private PreparedStatement ps = null;  
	private ResultSet rs = null;

	//这里获取了上一个界面的参数
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//告诉浏览器要以这种方式去解析文档
		response.setCharacterEncoding("utf-8");
		String id = MyTools.getNewString(request.getParameter("id")); //确保正确
		String password = request.getParameter("password");
		System.out.println("LoginCLServlet:id:"+id+" password:"+password);
		
//		sql = "select *from users";//SQL语句  
//        db1 = new DBHelper(sql);//创建DBHelper对象  
//        
//        try {  
//            ret = db1.pst.executeQuery();//执行语句，得到结果集  
//            while (ret.next()) {  
//                String uid = ret.getString(1);  
//                String ufname = ret.getString(2);  
//          
//                System.out.println(uid + "\t" + ufname + "\t" );  
//            }//显示数据  
//            ret.close();  
//            db1.close();//关闭连接  
//        } catch (SQLException e) {  
//            e.printStackTrace();  
//        }  
		
		//到数据库中验证
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/root", "root", "123456");
			ps = ct.prepareStatement("select * from users where id=? and password=?");
			ps.setObject(1,id);
			ps.setObject(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				request.getRequestDispatcher("/MainFrame").forward(request, response);
			} else{
				request.setAttribute("err", "用户ID或者密码错误");
				request.getRequestDispatcher("/LoginServlet").forward(request, response);
			}
		} catch (Exception e){
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
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
