package com.hpe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.bean.User;
import com.hpe.service.IUserService;
import com.hpe.service.impl.UserServiceImpl;

/**
 * 对登陆业务的控制类
 * @author chaoling
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

		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		// 2.获取用户名及密码
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		// 3.将用户名及密码封装为User
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);
		// 4. 调用UserService的login方法，并接收返回值
		user = userService.login(user);
		// 5.根据返回值做出不同的响应
		if (user != null) {
			// 登陆成功
			// 1.将登陆用户的信息保存到session中
			request.getSession().setAttribute("user", user);
			// 2.重定向到/user/list.jsp
			response.sendRedirect(request.getContextPath()+"/user/UserServlet");
		} else {
			// 登陆失败
			response.sendRedirect(request.getContextPath() + "/index.jsp" + "?flag=1");
		}

	}

}
