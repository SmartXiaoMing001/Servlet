package com.cjk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCL extends HttpServlet {

	/**
	 * 第一界面，这个界面的response中包含username、password，作为下一个界面的request
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//
		String value = request.getParameter("iskeepinfo");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if(value!=null && value.equals("kepp")){
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(7*2*24*3600);
			response.addCookie(cookie);
			request.getRequestDispatcher("/OK").forward(request, response);
		} else {
			request.getRequestDispatcher("/OK").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}