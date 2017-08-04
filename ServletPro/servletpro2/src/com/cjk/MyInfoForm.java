package com.cjk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyInfoForm extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//告诉浏览器要以这种方式去解析文档
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<form action = '/servletpro2/RegisterCL' method='post'>");
		
		//
		out.println("用户名：<input tyep='text' name='username'/><br/>");
		
		//
		out.println("密    码：<input type='password' name='password'/><br/>");
		
		//
		out.println("性    别：<input type='radio' name='sex' value='男'/>男"
				+ "<input type='radio' name='sex' value='女'/>女 <br/>");
		
		//
		out.println("你的爱好:<input type='checkbox' name='hobby' value='音乐'>音乐"
				+ "<input type='checkbox' name='hobby' value='体育'>体育"
				+ "你的爱好:<input type='checkbox' name='hobby' value='美术'>美术<br/>");
		
		//
		out.println("所在城市:<select name='city'>"
				+ "<option value='bj'>北京</option>"
				+ "<option value='cq'>重庆</option></select>");
		
		//
		out.println("<br/>你的介绍:<textarea cols='20' rows='10' name='intro'>请输入介绍</textarea><br/>");
		
		//
		out.println("提交照片:<input type='file' name='photo'><br/>");
		
		//hidden来传数据
		out.println("<input type = 'hidden' value='abc' name='hidden'/>");
		
		out.println("<input type='submit'>");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
