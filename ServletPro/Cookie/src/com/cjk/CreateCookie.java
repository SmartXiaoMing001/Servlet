package com.cjk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//这里获取了上一个界面的参数
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//告诉浏览器要以这种方式去解析文档
		response.setCharacterEncoding("utf-8");
		
		Cookie cookie = new Cookie("name", "caojingkun"); //name - value
		
		//life-circle，没有时间，浏览器关闭即失效
		cookie.setMaxAge(3600); 
		
		//
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}