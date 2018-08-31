package com.hpe.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.dao.UserDao;
import com.hpe.po.User;

/**
 * TODO 注册业务处理
 * @author chaoling
 *
 */
@WebServlet("/registe")
public class RegisteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String[] hobbys = request.getParameterValues("hobbys");
		String hobby = "";
		String msg = "";
		User user = null;
		
		if(hobbys != null){
			for(String str : hobbys){
				hobby = hobby + str;
			}
		}
		
		try {
			user = userDao.selectByUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user == null){
			user = new User(0, userName, password, sex, hobby);
			int res = 0;
			try {
				res = userDao.registe(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(res > 0){
				msg = "注册成功";
			} else {
				msg = "注册失败";
			}
			
		} else {
			msg = "该用户名已存在";
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(msg);
		
	}

}
