package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExitServlet")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		//session中的user移除
		request.getSession().removeAttribute("user");
		//从
		Cookie[] cookies = request.getCookies();
		
		if ( cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if ("autoLogin".equals(cookie.getName())) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	
	}

}
