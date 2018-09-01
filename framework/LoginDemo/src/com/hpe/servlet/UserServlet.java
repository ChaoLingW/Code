package com.hpe.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

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

/**
 * User业务控制
 * 
 * @author chaoling 2018年9月1日
 */

@WebServlet("/user/UserServlet")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl(); // userService对象

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取查询条件
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String createDate = request.getParameter("createDate");

		// 封装查询条件User
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

		// 将查询条件封装到page
		page.setUser(user);

		// 调用UserService中searchUser
		page = userService.searchUser(page);

		// 将users设置到reqeust域中
		request.setAttribute("page", page);
		request.setAttribute("formUser", user);// 数据回显

		// 请求转发到/user/list.jsp
		request.getRequestDispatcher("/user/list.jsp").forward(request, response);

	}

	/**
	 * 修改控制
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 得到用户id
		String userId = request.getParameter("userId");

		// 调用Userservice --findUserById方法，接收返回值
		User modUser = userService.findUserById(Integer.parseInt(userId));

		// 设置到request中
		request.setAttribute("modUser", modUser);

		// 请求转发到modify.jsp
		request.getRequestDispatcher("/user/modify.jsp").forward(request, response);

	}

	/**
	 * 修改控制的实际操作
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取修改信息
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String[] loves = request.getParameterValues("love");
		// 获取 love
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

		// 构造User 封装修改信息
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

		// 调用Userservice中的方法
		boolean isUpdate = userService.updateUserById(user);
		if (isUpdate) {
			// 修改成功
			response.sendRedirect(request.getContextPath() + "/user/UserServlet");
		} else {
			// 修改失败
			request.setAttribute("modUser", user);
			request.getRequestDispatcher("/user/modify.jsp").forward(request, response);
		}
	}

	/**
	 * 根据id删除用户的控制方法
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 得到用户id
		String userId = request.getParameter("userId");
		// 调用Userservice中的方法
		boolean idDelete = userService.deleteUserById(Integer.parseInt(userId));
		if (idDelete) {
			// 删除成功
			response.sendRedirect(request.getContextPath() + "/user/UserServlet");
		} else {
			// 删除失败
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}
}
