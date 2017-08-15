package com.cjk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookie2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//这里获取了上一个界面的参数
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//告诉浏览器要以这种方式去解析文档
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//可以保存多个cookie,明文的方式存取的！可以加密后保存
		Cookie cookie = new Cookie("name", "mvc");
		Cookie cookie2 = new Cookie("age", "18");

		cookie.setMaxAge(3600);
		cookie2.setMaxAge(3600);

		response.addCookie(cookie);
		response.addCookie(cookie2);

		out.println("创建了cookie"); // 下次里面的文字要替换了！
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
