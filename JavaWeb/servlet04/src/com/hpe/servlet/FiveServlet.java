package com.hpe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.po.User;


@WebServlet("/five")
public class FiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] array={"张三","李四","王五"};
		
		List<String> list = new ArrayList<String>();
		
		list.add("安琪拉");
		list.add("后羿");
		list.add("亚瑟");
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		//构建User的实例
		User user = new User(11,"李白");
		session.setAttribute("user", user);
		
		//构建List<User>
		
		List<User> users = new ArrayList<User>();
		users.add(new User(11,"王昭君"));
		users.add(new User(12,"甄姬"));
		users.add(new User(13,"吕布"));
		
		request.setAttribute("users", users);
		
		List<User> users1 = new ArrayList<User>();
		request.setAttribute("users1", users1);
		
		//构建Map
		Map<String, User> map = new HashMap();
		
		map.put("dw", new User(11,"典韦"));
		map.put("aa", new User(11,"aa"));
		map.put("bb", new User(11,"bb"));
		request.setAttribute("map", map);
		
		request.setAttribute("array", array);
		request.getRequestDispatcher("/jstl.jsp").forward(request, response);
		

	}

}
