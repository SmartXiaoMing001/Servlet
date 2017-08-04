package com.cjk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetRequestHeader extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//告诉浏览器要以这种方式去解析文档
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//
		String host = request.getHeader("Host"); // = request.getRequestHost
		System.out.println(host);
		
		//接口
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			
			//取出头名字
			String headername = headers.nextElement();
			System.out.println(headername+":"+request.getHeader(headername));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
