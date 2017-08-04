package com.cjk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCL extends HttpServlet {

	/**
	 * About browser of cache! a little important
	 */
	private static final long serialVersionUID = 1L;
	int i = 0;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); //接受的地方
		response.setContentType("text/html;charset=utf-8"); //可以回送的地方
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String hobbies[] = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		String intro = request.getParameter("intro");
		String hidden = request.getParameter("hidden");
		
		out.println("用户名="+username+"<br/>");
		out.println("密    码="+password+"<br/>");
		out.println("性    别="+sex+"<br/>");
		if(hobbies.length>0){
			for(int i=0;i<hobbies.length;i++){
				out.println("你的爱好有"+hobbies[i]);
			}
		} else{
			out.println("你没有爱好");
		}
		out.println("<br/>所在城市:"+city);
		out.println("<br/>个人介绍："+intro);
		out.println("<br/>隐藏控件传递的数据是:"+hidden);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
