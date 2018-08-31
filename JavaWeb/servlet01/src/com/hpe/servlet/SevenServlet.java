package com.hpe.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/se/ven")
public class SevenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.打印所有imgs下的图片的名称
		ServletContext ctx = getServletContext();
		//得到imgs的绝对路径
		String imgsPath = ctx.getRealPath("/imgs");
		//构造File
		File file = new File(imgsPath);
		//得到此文件中的所有文件名构成的数组
		String[] names = file.list();
		for(String name : names){
			System.out.println(name);
		}
		
		//2.在浏览器中显示所有的imgs下的图片
		response.setContentType("text/html;charset=utf-8");
		String contextPath = ctx.getContextPath();// /servlet01
		
		for(String name : names){
			response.getWriter().write("<img src='"+contextPath+"/imgs/"+name+"' width=100 height=100 />");
		}
		
		//response.getWriter().write("<img src='imgs/11.jpg' width=100 height=100 />");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
