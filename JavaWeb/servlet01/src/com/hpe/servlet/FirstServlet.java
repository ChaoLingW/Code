package com.hpe.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 实现Servlet的方式一：实现Servlet接口
 * 
 * Servlet生命周期函数
 * @author chaoling
 *
 */
public class FirstServlet implements Servlet{

	/**
	 * 第一次请求会调用，创建实例
	 */
	public FirstServlet() {
		System.out.println("constructor...");
	}
	
	/**
	 * 第一次请求的时候会调用（一次），完成一些初始化的工作，tomcat服务器调用
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		Enumeration<String> names = config.getInitParameterNames();
		
		
		
		System.out.println("init...");
	}

	/**
	 * 每次请求都会调用，tomcat服务器调用
	 * ServletRequest：请求的对象
	 * ServletResponse：响应的对象
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		//设置响应内容的类型
		res.setContentType("text/html;charset=utf-8");
		
		res.getWriter().write("今天是星期一," + name);
	
	}
	
	/**
	 * web应用程序重新加载或者销毁服务的时候调用（一次），由tomcat服务器调用
	 */
	@Override
	public void destroy() {
		
		System.out.println("destroy...");
	}
	
	
	/**
	 * 获取这个servlet在web.xml中的配置信息
	 */
	@Override
	public ServletConfig getServletConfig() {
		
		System.out.println("getServletConfig...");
		return null;
	}

	/**
	 * 获取这个servlet的名称
	 */
	@Override
	public String getServletInfo() {
		
		System.out.println("getServletInfo...");
		return null;
	}                                                                                                                                                                                                                                                     
}
