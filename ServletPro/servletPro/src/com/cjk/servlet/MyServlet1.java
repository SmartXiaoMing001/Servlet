package com.cjk.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int ticket = 3;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//这个是属于同步代码，防止线程并发
		synchronized (this) {
			if(ticket > 0){
				System.out.println("你买到票了");
				try {
					Thread.sleep(10*1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				ticket--;
			} else {
				System.out.println("你没买到票");
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("hello,world--000-*-->" + new java.util.Date().toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//一般开发人员习惯把doGet、doPost合二为一
		this.doGet(request, response);
	}

}
