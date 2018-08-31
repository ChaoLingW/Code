package com.hpe.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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

		//得到查询条件,并封装user对象
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setSex(request.getParameter("sex"));
		user.setAddress(request.getParameter("address"));
		user.setCreateDate(request.getParameter("createDate"));
		
		// 查询第几页
		String curPage = request.getParameter("curPage");

		if (curPage == null || "".equals(curPage.trim())) {
			curPage = "1";
		}
		
		// 构建Page-->第几页、页数
		Page page = new Page();

		page.setCurPage(Integer.parseInt(curPage));
		page.setPageNumber(2);
		// 调用UserService中searchUser方法
		page = userService.searchUser(page, user);

		//将page设置到request域中
		request.setAttribute("page", page);
		//将 users设置到request域中
		request.setAttribute("formUser", user);//数据回显
		// 请求转发/user/list.jsp
		request.getRequestDispatcher("/user/list.jsp").forward(request, response);
	}

	public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1.得到用户id
		String id = request.getParameter("userId");
		// 2.调用UserService--findUserById方法，接收返回值
		User modUser = userService.findUserById(Integer.parseInt(id));
		// 3.设置到request中
		request.setAttribute("modUser", modUser);
		// 4.请求转发到modify.jsp
		request.getRequestDispatcher("/user/modify.jsp").forward(request, response);

	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
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
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setUpdateDate(ToolUtil.getStrDate(now));

		// 调用service中的update的方法获取返回值
		boolean update = userService.updateUser(user);

		// 对不同的返回值，做出不同的响应
		if (update) {
			// 更新成功
			response.sendRedirect(request.getContextPath() + "/user/UserServlet");
		} else {
			// 更新失败
			
			request.setAttribute("modUser", user);
			request.getRequestDispatcher("/user/modify.jsp").forward(request, response);

		}

	}

}
