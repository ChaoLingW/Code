package com.hpe.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.po.User;
import com.hpe.service.IUserService;
import com.hpe.service.UserServiceImpl;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	private static int count = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		try {
			Method method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 调用service方法，进行用户验证
		User currentUset = userService.userLogin(username, password);

		// 检查验证结果
		// 验证通过
		if (currentUset != null) {

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", currentUset);
			request.setAttribute("msg", "<script>alert('登录成功')</script>");
			select(request, response);
		} else// 验证失败
		{
			request.setAttribute("msg", "<script>alert('登录失败')</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}

	protected void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 创建对象
		User user = new User();
		// 判断是否是第一访问
		if (count > 0) {
			// 获取查询条件
			String username = request.getParameter("username");
			String id = request.getParameter("id");
			String sex = request.getParameter("sex");
			/**
			 * 当条件不是null 或者''时封装到对象
			 */
			if (username != null && !"".equals(username)) {
				user.setUsername(username);
			}
			if (id != null && !"".equals(id)) {
				user.setId(Integer.parseInt(id));
			}
			if (sex != null && !"".equals(sex)) {
				user.setSex(sex);
			}
			count++;
		}
		// 调用函数 获取返回值
		List<User> users = userService.select(user);
		// 获取session
		HttpSession httpSession = request.getSession();
		// 设置属性 返回
		httpSession.setAttribute("users", users);
		response.sendRedirect(request.getContextPath() + "/success.jsp");
	}

	protected void updateById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 创建对象
		User user = new User();
		// 获取修改条件
		String username = request.getParameter("username");
		String id = request.getParameter("id");
		// String id = (String) request.getAttribute("id");
		System.out.println(id);
		String sex = request.getParameter("sex");
		String realName = request.getParameter("realName");
		String password = request.getParameter("password");
		// 未设置修改条件直接返回sucess.jsp
		// 判断 mapper文件中<set>中<if>不能都是否，否则会导致异常
		if (sex == null && username == "" && password == "" && realName == "") {
			response.setContentType("text/html;charset=utf-8");
			response.sendRedirect(request.getContextPath() + "/success.jsp");
			return;

		}
		if (username != null && !"".equals(username)) {
			user.setUsername(username);
		}
		if (id != null && !"".equals(id)) {
			user.setId(Integer.parseInt(id));
		}
		if (sex != null && !"".equals(sex)) {
			user.setSex(sex);
		}
		if (realName != null && !"".equals(realName)) {
			user.setRealName(realName);
		}
		if (password != null && !"".equals(password)) {
			user.setPassword(username);
		}

		// 调用函数 获取返回值
		int row = userService.updateById(user);
		// 获取session
		HttpSession httpSession = request.getSession();
		// 设置属性 返回
		httpSession.setAttribute("res", row);
		select(request, response);
	}

	protected void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 传递数据
		List<Integer> ids = new ArrayList<>();
		// 获取传递过来的id组成的字符串
		String idStr = request.getParameter("id");
		//  字符串不为空，且长度大于0
		if( idStr !=null && idStr.length() != 0) {
			// 分割字符串
			String[] idsArr = idStr.split(",");
			// 遍历赋值  最后一位为''
			for(int i = 0 ; i < idsArr.length; i++) {
				if(!"".equals(idsArr[i])){
					int id = Integer.parseInt(idsArr[i]);
					ids.add(id);
				}
			}
			// 调用方法
			userService.deleteById(ids);
		}
		select(request, response);
	}

}
