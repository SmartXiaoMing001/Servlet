package com.cjk.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	/**
	 * 图片的下载
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//show file download(English && Chinese) 
//		String filename = "cat1.jpg";
//		response.setHeader("Content-Disposition", "attachment;filename="+filename);
//		
//		//open file，read the byte stream first，and then send file to brower
//		String path = this.getServletContext().getRealPath("/images/"+filename);//全路径
		String filename = java.net.URLEncoder.encode("猫咪.jpg","utf-8");// ;
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		String path = this.getServletContext().getRealPath("/images/"+"猫咪.jpg");//全路径
		FileInputStream fis = new FileInputStream(path);
		
		//buffer byte array
		byte buff[] = new byte[1024]; //also bigger,no matter
		int len = 0;//表示实际每一次读取了多少个字节
		OutputStream os = response.getOutputStream();
		while((len = fis.read(buff))>0){ //download 1024bytes one time
			System.out.println(len);
			os.write(buff,0,len); //last time 377bytes!
		}
		
		//
		os.close();
		fis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
