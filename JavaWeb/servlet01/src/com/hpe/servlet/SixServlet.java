package com.hpe.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/six")
public class SixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ServletContext获取项目的真实路径和应用上下文
		
		// 1.得到ServletContext
		ServletContext ctx = getServletContext();
		
		// 2.如何获取真实路径-->在服务器上的真实路径
		String path = ctx.getRealPath("/");
		System.out.println(path);
		
		String path1 = ctx.getRealPath("/imgs");
		System.out.println(path1);
		
		// 3.获取上下文路径
		String path2 = ctx.getContextPath();
		System.out.println(path2);//   /servlet01
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
