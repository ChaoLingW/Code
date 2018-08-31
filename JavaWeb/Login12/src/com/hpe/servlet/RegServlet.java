package com.hpe.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.bean.User;
import com.hpe.service.IUserService;
import com.hpe.service.impl.UserServiceImpl;
import com.hpe.util.ToolUtil;

@WebServlet("/login/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IUserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		//得到表单中数据
		
		String username = request.getParameter("username");
		
		String pwd = request.getParameter("pwd");
		
		String sex = request.getParameter("sex");
		
		String[] loves = request.getParameterValues("love");
		
		String love="";
		if(loves!=null&&loves.length>0)
		{
			for(String s :loves)
			{
				love+=s+",";
			}
			love=love.substring(0, love.length()-1);
		}
		
		
		String birthday = request.getParameter("birthday");
		
		String address = request.getParameter("address");
		
		String email = request.getParameter("email");
		
		LocalDateTime now = LocalDateTime.now();
		
		//构造User
		
		User user  = new User();
		user.setAddress(address);
		user.setBirthday(birthday);
		user.setCreateDate(ToolUtil.getStrDate(now));
		user.setEmail(email);
		user.setLove(love);
		user.setPwd(pwd);
		user.setSex(sex);
		user.setUpdateDate(ToolUtil.getStrDate(now));
		user.setUsername(username);
		
		
		//调用servie中saveUser的方法
		boolean isSave = userService.saveUser(user);
		
		if(isSave)
		{
			//添加成功
			//重定向到index.jsp		flag=2
			response.sendRedirect(request.getContextPath()+"/index.jsp"+"?flag=2");
		}
		else
		{
			//添加失败
			request.setAttribute("regUser", user);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		}
		
	}

}
