package cn.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/four")
public class FourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String msg = "第一次登陆";

		// 当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = sdf.format(date);

		// 创建Cookie
		Cookie cookie = new Cookie("lastTime", strDate);
		//设置过期时间
		cookie.setMaxAge(60*60*24*365);
		// 将此cookie 发送到浏览器
		response.addCookie(cookie);

		// 得到请求中名称为lastTime的cookie，在得到具体的时间
		Cookie[] cookies = request.getCookies();
		// 如果请求中有cookie才遍历
		if (cookies != null && cookies.length > 0) {
			for (Cookie coo : cookies) {
				if ("lastTime".equals(coo.getName())) {
					msg = "您上一次访问的时间为：" + coo.getValue();
				}
			}
		}
		
		out.write(msg);

	}

}
