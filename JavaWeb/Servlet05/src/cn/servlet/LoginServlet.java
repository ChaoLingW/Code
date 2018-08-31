package cn.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.po.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//获取用户名及密码
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		//验证用户名及密码是否正确
		if((name!=null &&!"".equals(name.trim()))&&(pwd!=null &&!"".equals(pwd.trim()))){
			
			//登陆成功
			System.out.println("登陆成功");
			
			User user = new User();
			user.setName(name);
			user.setPwd(pwd);
			//将当前的用户信息保存在session中
			request.getSession().setAttribute("user", user);
			
			//判断是否需要自动登陆
			String autoLogin = request.getParameter("autoLogin");
			//如果选中了，将登陆人的信息保存到Coolik中，同时设置Cookie有效时间，发送给客户端
			if(autoLogin != null & "1".equals(autoLogin.trim())){
				//选择了自动登陆
				name = URLEncoder.encode(name, "utf-8");
				pwd = URLEncoder.encode(pwd, "utf-8");
				//登陆人的信息保存到Cookie
				Cookie cookie = new Cookie("autoLogin", name +"#" + pwd);
				//设置时长
				cookie.setMaxAge(60*60*24);
				//发送给客户端
				response.addCookie(cookie);
			}
			
			
		} else {
			//登陆失败
			System.out.println("登陆失败");
		}
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	
	}

}
