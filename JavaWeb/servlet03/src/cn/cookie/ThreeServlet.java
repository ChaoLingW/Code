package cn.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/three")
public class ThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset-utf-8");
		
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		if (cookies != null && cookies.length > 0) {

			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				out.write("cookieName" + name + ",cookieValue:" + value);

			}
		} else {
			Cookie cookie = new Cookie("name", "zhangsan");
			//设置过期时间setMaxAge
			cookie.setMaxAge(20);//秒数
			
			response.addCookie(cookie);
		}
		

	}

}
