package com.cjk;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

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
		
		//
		Cookie cookies[] = request.getCookies();
		boolean pending = false;
		if(cookies.length>0){
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String name = cookie.getName();
				if(name.equals("lasttime")){
					out.print("您上次登录时间是:"+cookie.getValue());
					//把当前日期保存到cookie中
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
					String nowTime = simpleDateFormat.format(new java.util.Date());
					Cookie myCookie = new Cookie("lasttime", nowTime);
					myCookie.setMaxAge(7*3600*24); //一周
					response.addCookie(myCookie);
					pending = true;
					break;
				}
			}
		}
		if(!pending) {
			out.println("您是第一次登录");
			
			//把当前日期保存到cookie中
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			String nowTime = simpleDateFormat.format(new java.util.Date());
			Cookie cookie = new Cookie("lasttime", nowTime);
			cookie.setMaxAge(7*3600*24); //一周
			response.addCookie(cookie);
			pending = true;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}