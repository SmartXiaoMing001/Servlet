package com.cjk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjk.domain.User;
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
		String username = MyTools.getNewString(request.getParameter("username")); //确保正确
		String password = request.getParameter("password");
		System.out.println("LoginCLServlet:username:"+username+" password:"+password);
		
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		
		if("速度".equals(username) && "123456".equals(password)){
			//下一界面
			response.sendRedirect("/UserManager/MainFrame?username="+username+"&password="+password);
			request.getSession().setAttribute("userobj", user);
			
		} else {
			//跳回去
			response.sendRedirect("/UserManager/LoginServlet");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
