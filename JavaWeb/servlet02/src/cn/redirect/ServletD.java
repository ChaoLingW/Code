package cn.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sd")
public class ServletD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * 重定向 特点： 1.客户端浏览器请求次数：2次 2.地址栏问题：地址栏发生变化
	 * 3.数据共享问题：通过request.setAttribute的方式不能共享数据，因为是不同的请求,可以通过url传参
	 * 4.路径中/开头的问题：以/开头，/代表的是服务器的地址
	 * 5.可以重定向到外部资源
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("name", "zhangsan");
		System.out.println("sd...");

		// 请求重定向 response.sendRedirect(path)
		// request.getContextPath() -->/web应用的名称  http://localhost:8080/servlet02/
		//response.sendRedirect(request.getContextPath() + "/se?pwd=123");
		response.sendRedirect("http://www.baidu.com");
	}

}
