package com.cjk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainFrame extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //没有会出来乱码
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id+"---"+password);
		out.println("<h1>欢迎登陆</h1>"); //h1是主标题
		out.println("<a href='/UserManager/LoginServlet'>返回重新登录</a>"); //详单与pop
		out.println("<h3>请选您要进行的操作</h3>");
		out.println("<a href='/UserManager/ManagerUsers'>管理用户</a>");
		out.println("<a href=''>添加用户</a>");
		out.println("<a href=''>查找用户</a>");
		out.println("<a href=''>退出系统</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
