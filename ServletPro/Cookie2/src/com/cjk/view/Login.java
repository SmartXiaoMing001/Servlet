package com.cjk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	/**
	 * 第一界面，这个界面的response中包含username、password，作为下一个界面的request
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = "";
		Cookie cookies[] = request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("id")){
					id = cookie.getValue();
				}
			}
		}
		
		// "<form action='/UserManager/LoginClServlet' method='post'>"
		out.println("<h1>用户登录</h1>");
		out.println("<form action='/Cookie2/LoginCL' method='post'>"); 
		out.println("用户id：<input type='text' name='id' value='"+id+"'/><br/>");
		out.println("密     码：<input type='password' name='password'/><br/>");
		out.println("<input type='checkbox' name='iskeepinfo' value='keep'/>在此电脑上保留用户名<br/>");
		out.println("<input type='checkbox' name='iskeepinfo' value='nokeep'/>不在此电脑上保留用户名<br/>");
		out.println("<input type='submit' value='登录'/><br/>");
		out.println("</form>");
		
		//
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
