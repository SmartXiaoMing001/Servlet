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
import com.cjk.domin.UserService;
import com.cjk.util.DBHelper;
import com.cjk.util.MyTools;


public class LoginClServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//这里获取了上一个界面的参数
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//告诉浏览器要以这种方式去解析文档
		response.setCharacterEncoding("utf-8");
		String id = MyTools.getNewString(request.getParameter("id")); //确保正确
		String password = request.getParameter("password");
	
		UserService userService = new UserService();
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setPassword(password);
		if(userService.checkUser(user)){
			request.getRequestDispatcher("/MainFrame").forward(request, response); //MainFrame的数据移动到当前Servlet中
		} else {
			request.setAttribute("err", "用户id或者密码有误");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
