package com.hpe.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.bean.User;
import com.hpe.service.IUserService;
import com.hpe.service.impl.UserServiceImpl;
import com.hpe.util.ToolUtil;

/**
 * TODO 注册业务控制类
 * 
 * @author chaoling
 */
@WebServlet("/login/RegisterServlet")
public class RegisterServlet extends HttpServlet {

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
		// 得到表单中的数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String pwd1 = request.getParameter("pwd1");
		String sex = request.getParameter("sex");
		String[] loves = request.getParameterValues("love");

		// 将数组loves转化为love（字符串）
		String love = "";
		if (loves != null && loves.length > 0) {
			for (String s : loves) {
				love += s + ",";
			}
			love = love.substring(0, love.length() - 1);
		}

		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		// 处理时间
		LocalDateTime now = LocalDateTime.now();

		// 构造User实例
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);
		user.setSex(sex);
		user.setLove(love);
		user.setBirthday(birthday);
		user.setAddress(address);
		user.setEmail(email);
		user.setCreateDate(ToolUtil.getStrDate(now));
		user.setUpdateDate(ToolUtil.getStrDate(now));

		// 调用service中的register的方法获取返回值
		boolean register = userService.register(user);

		// 对不同的返回值，做出不同的响应
		if (register) {
			// 注册成功
			/// 注册成功直接跳转到主界面
			/*
			 * //将用户信息存放在session，list.jsp做了验证，没有session中的user，无法跳转
			 * request.getSession().setAttribute("user", user);
			 * //重定向到/login/ShowListServlet
			 * response.sendRedirect(request.getContextPath() +
			 * "/login/ShowListServlet" );
			 */
			response.sendRedirect(request.getContextPath() + "/index.jsp" + "?falg=2");
		} else {
			
			/*
			 * /// 注册失败，重定向到error.jsp
			 * response.sendRedirect(request.getContextPath() + "/error.jsp");
			 */
			 request.setAttribute("regUser", user);
			 request.getRequestDispatcher("register.jsp").forward(request, response);
			
			
			
			}

	}

}
