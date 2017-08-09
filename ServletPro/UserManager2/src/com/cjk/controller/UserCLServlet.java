package com.cjk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjk.domin.UserService;

public class UserCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/hetml;charset=utf-8");
		PrintWriter out = response.getWriter();
		//receiveID
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		if(type.equals("delete")){
			if(new UserService().delUser(id)){
				request.getRequestDispatcher("/Ok").forward(request, response);
			} else{
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}
		if(type.equals("update")){
			if(new UserService().updateId(id)){
				request.getRequestDispatcher("/Ok").forward(request, response);
			} else{
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
