package com.cjk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String referer = request.getHeader("Referer");
		if(referer == null){
			response.sendRedirect("/servletPro/Error");
			return;
		}
		out.println("Referer="+referer);
		
//		//通过request对象来获取http请求信息
//		String host = request.getHeader("Host"); //获取主机名
//		out.println("host="+host);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
