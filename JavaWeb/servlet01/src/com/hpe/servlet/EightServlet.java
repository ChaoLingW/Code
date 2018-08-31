package com.hpe.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EightServlet")
public class EightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();//count 值
		//获取属性值
		Object obj = context.getAttribute("count");
		System.out.println(obj);
		
		int count = 0;
		//如果没有，设置为1
		if(obj == null){
			
		}else {
			//如果有的话，+1;
			count = ((int)obj) + 1;
		}
		System.out.println(count);
		//设置属性值
		context.setAttribute("count", count);
		
		System.out.println(obj);
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
