package com.hpe.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 实现Servlet的第二种方式，继承GenericServlet（只有一个抽象方法service(ServletRequest req, ServletResponse res)）
 * @author chaoling
 *
 */

public class MyGenericServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * 初始化的时候要完成一些初始化的工作，重写init()方法
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		//打印servlet的名称
		System.out.println(getServletName());
		
		//打印web应用程序的路径
		System.out.println(getServletContext().getContextPath());
		//打印初始化参数（name)的值
		System.out.println(getInitParameter("name"));
		
	}

}
