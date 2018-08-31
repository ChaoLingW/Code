package com.hpe.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 测试：ServletConfig:当前Web应用的ServletContext和Servlet的配置信息
 * getServletName()    获取当前Servlet在web.xml中配置的名字
 * getServletContext()   获取代表当前web应用的ServletContext对象
 * getInitParameter(String)   获取当前Servlet指定名称的初始化参数的值
 * getInitParameterNames()  获取当前Servlet所有初始化参数的名字组成的枚举
 */
public class SecondServlet implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		String servletName = config.getServletName();
		System.out.println(servletName + "!");
		
		ServletContext context = config.getServletContext();//当前web应用的对象
		System.out.println(context.getContextPath());  // /servlet01
		
//		获取当前Servlet指定名称的初始化参数的值，如果无此名称的参数，返回null
		String userName = config.getInitParameter("userName");
		System.out.println(userName);
		
//		getInitParameterNames()  获取当前Servlet所有初始化参数的名字组成的枚举
		Enumeration<String> names = config.getInitParameterNames();
		
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name+ "--->" + config.getInitParameter(name));
		}
	
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
