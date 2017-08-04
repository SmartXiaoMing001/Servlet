package com.cjk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjk.util.MyTools;

public class GetInfoServlet extends HttpServlet{

	/**
	 * url=http://localhost:8080/servletpro2/GetInfoServlet (complete URL = web.name + resource.name)
     * uri=/servletpro2/GetInfoServlet (resource.name)
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//告诉浏览器要以这种方式去解析文档
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//get URL
		String url = request.getRequestURL().toString();
		System.out.println("url="+url);
		
		//get URI
		String uri = request.getRequestURI().toString();
		System.out.println("uri="+uri);
		
		//这就是别人究竟请求了什么！！！后台就是这么写的！！！
		String quertString = request.getQueryString();
		System.out.println("queryString="+quertString);
		
		//Just to deal with Chinese!
		String queryStrings[] = quertString.split("&");
		for(String s : queryStrings){
			String result[] = s.split("=");
			out.println(result[0] + "~" + MyTools.getNewString(result[1])); //show to net!
			out.println("<br>");
		}
		
		//获取请求放的IP地址,为啥这个地方没有获得IP地址！！！
		String address = request.getRemoteAddr();
		System.out.println("address="+address);
		if(address.equals("172.21.228.10")){
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
