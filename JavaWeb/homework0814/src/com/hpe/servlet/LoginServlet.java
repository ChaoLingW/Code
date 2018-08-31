package com.hpe.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.dao.UserDao;
import com.hpe.po.User;

/**
 * TODO 登录业务处理
 * @author chaoling
 *
 */
public class LoginServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	private UserDao login = new UserDao();
	private User user = new User();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置编码格式，否则会乱码
		resp.setContentType("text/html;charset=utf-8");
		//获取信息
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		//封装对象
		user = new User(userName, password);
		try {
			//查询，并获取返回值
			user = login.login(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		String msg = null;
		//判断
		if(user == null){
			msg = "用户名或密码不存在";
		} else{
			msg = "登录成功";
		}
	
		resp.getWriter().write(msg);
	}

}
