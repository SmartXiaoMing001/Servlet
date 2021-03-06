package com.cjk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjk.domain.User;

public class MainFrame extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //没有会出来乱码
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = (User)request.getSession().getAttribute("userobj");
		System.out.println("MainFrame:"+username + "---" + password + "-->" + user.getName());
		
		out.println("<h1>主界面</h1>"+username+"---"+password + "-->" + user.getName()); //h1是主标题
		out.println("<a href='/UserManager/'>返回重新登录</a>"); //详单与pop
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
