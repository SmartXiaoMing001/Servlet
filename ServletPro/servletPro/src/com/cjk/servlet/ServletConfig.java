package com.cjk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfig extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String encoding = this.getServletConfig().getInitParameter("encoding");
		response.setCharacterEncoding(encoding); //从配置文件中获取
		PrintWriter out = response.getWriter();
		out.println("编码是："+encoding);
		
		Enumeration<String> names = this.getServletConfig().getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name);
			System.out.println(this.getServletConfig().getInitParameter(name));
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
