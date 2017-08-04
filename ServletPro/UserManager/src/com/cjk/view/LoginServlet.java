package com.cjk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 第一界面，这个界面的response中包含username、password，作为下一个界面的request
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//请求servlet之后，out.println就是直接输出到界面上的东西
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回一个界面（html） 
		out.println("<h1>用户登录</h1>");
		out.println("<form action='/UserManager/LoginClServlet' method='post'>"); /**这里是action执行方法!*/
		out.println("用户名：<input type='text' name='username'/><br/>");
		out.println("密     码：<input type='password' name='password'/><br/>");
		out.println("<input type='submit' value='登录'/><br/>");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
