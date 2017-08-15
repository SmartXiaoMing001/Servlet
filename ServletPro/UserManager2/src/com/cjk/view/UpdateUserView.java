package com.cjk.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjk.domain.User;


public class UpdateUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		User user = (User) request.getAttribute("userInfo");
		out.println("<h1>修改用户</h1>");
		out.println("<form action='/UserManager/UserCLServlet?type=update' method='post'>");
		out.println("<table border=1px width =300px>");
		out.println("<tr><td>id</td><td><input type='text' name='id' readonly value='"+user.getId()+"'/></td></tr>");
		out.println("<tr><td>用户名</td><td><input type='text' name='userName' value='"+user.getName()+"'/></td></tr>");
		out.println("<tr><td>email</td><td><input type='text' name='email' value='"+user.getEmail()+"'/></td></tr>");
		out.println("<tr><td>级别</td><td><input type='text' name='grade' value='"+user.getGrade()+"'/></td></tr>");
		out.println("<tr><td>密码</td><td><input type='text' name='password' value='"+user.getPassword()+"'/></td></tr>");
		out.println("<tr><td><input type='submit' value='修改用户'/></td>"
				+ "<td><input type='reset' value='重新填写'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
