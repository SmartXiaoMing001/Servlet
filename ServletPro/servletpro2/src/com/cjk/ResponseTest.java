package com.cjk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseTest extends HttpServlet {

	/**
	 * About browser of cache! a little important
	 */
	private static final long serialVersionUID = 1L;
	int i = 0;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		/**
		 * 1.let browser have no cache!!!
		 * 2.compatibility(兼容性)
		 * */
		response.setDateHeader("Expires", -1);//1
		response.setHeader("Cache-Control", "no-cache");//2
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		out.println("hello,world!" + new java.util.Date().toString());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
