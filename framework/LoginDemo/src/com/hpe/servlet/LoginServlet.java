package com.hpe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.bean.User;
import com.hpe.service.IUserService;
import com.hpe.service.impl.UserServiceImpl;

/**
 * 处理登录请求
 * 
 * @author chaoling 2018年9月1日
 */
@WebServlet("/login/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");

		// 获取用户名及密码
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		// 将用户名及密码封装为User
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);

		// 调用UserService的login方法，并接收返回值
		User res = userService.login(user);

		// 根据返回值来决定不同的处理方式
		if (res != null) {
			// 登陆成功
			// 将登陆人的信息保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("user", res);

			// 2.重定向到/user/UserServlet
			response.sendRedirect(request.getContextPath() + "/user/UserServlet");

		} else {
			// 失败
			response.sendRedirect(request.getContextPath() + "/index.jsp" + "?flag=1");
		}
	}

}
