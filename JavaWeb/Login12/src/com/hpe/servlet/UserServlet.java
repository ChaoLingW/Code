package com.hpe.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.base.BaseServlet;
import com.hpe.bean.User;
import com.hpe.service.IUserService;
import com.hpe.service.impl.UserServiceImpl;
import com.hpe.util.Page;
import com.hpe.util.ToolUtil;

@WebServlet("/user/UserServlet")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 得到查询条件
		String username = request.getParameter("username");

		String sex = request.getParameter("sex");

		String address = request.getParameter("address");

		String createDate = request.getParameter("createDate");

		// 构建封装了查询条件的User
		User user = new User();
		user.setUsername(username);
		user.setAddress(address);
		user.setSex(sex);
		user.setCreateDate(createDate);

		// 查询第几页
		String curPage = request.getParameter("curPage");

		if (curPage == null || "".equals(curPage.trim())) {
			curPage = "1";
		}
		// 构建Page---》第几页、一页几条
		Page page = new Page();

		page.setCurPage(Integer.parseInt(curPage));
		page.setPageNumber(2);

		// 调用UserService中searchUser

		page = userService.searchUser(page, user);

		// 将users设置到reqeust域中
		request.setAttribute("page", page);

		request.setAttribute("formUser", user);// 数据回显

		// 请求转发到/user/list.jsp
		request.getRequestDispatcher("/user/list.jsp").forward(request, response);

	}

	public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1.得到用户id
		String userId = request.getParameter("userId");

		// 2.调用Userservice --findUserById方法，接收返回值
		User modUser = userService.findUserById(Integer.parseInt(userId));

		// 3.设置到request中
		request.setAttribute("modUser", modUser);

		// 4.请求转发到modify.jsp

		request.getRequestDispatcher("/user/modify.jsp").forward(request, response);

	}

	public void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		String sex = request.getParameter("sex");

		String[] loves = request.getParameterValues("love");

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
		
		String createDate = request.getParameter("createDate");
		
		String id = request.getParameter("id");

		LocalDateTime now = LocalDateTime.now();

		// 构造User

		User user = new User();
		user.setAddress(address);
		user.setBirthday(birthday);
		user.setCreateDate(createDate);
		user.setEmail(email);
		user.setLove(love);
		user.setPwd(pwd);
		user.setSex(sex);
		user.setUpdateDate(ToolUtil.getStrDate(now));
		user.setUsername(username);
		user.setId(Integer.parseInt(id));
		
		//调用Userservice中的方法
		boolean isUpdate = userService.updateUserById(user);
		if(isUpdate)
		{
			response.sendRedirect(request.getContextPath()+"/user/UserServlet");
		}
		else
		{
			request.setAttribute("modUser",user);
			request.getRequestDispatcher("/user/modify.jsp").forward(request, response);
		}
	}
}
