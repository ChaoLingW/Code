package com.hpe.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO 如何获取web应用的初始化参数
 * @author chaoling
 *
 */
@WebServlet("/fifth")
public class FifthServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.得到ServletContext
		ServletContext ctx = getServletContext();
	
		// 2.所有web应用的初始化参数的名称构成的一个枚举
		Enumeration<String> names = ctx.getInitParameterNames();
		
		while(names.hasMoreElements()){
			String name = names.nextElement();//初始化参数的名称
			String value = ctx.getInitParameter(name);
			System.out.println(name + "---" + value);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
