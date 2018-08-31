package cn.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sa")
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * 请求的转发 特点：同一个请求 1.客户端请求次数问题：客户端只发起一次请求 2.地址栏问题：地址未变(原因：只请求了一次)
	 * 3.数据共享问题：共享request
	 * 4./问题：在请求转发的路径中：如果不以/开头，相对路径。如果以/开头，代表当前web应用的路径.(建议在请求转发时带上/)
	 * 5.只能转发到当前web应用中的组件
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ServletA");
		// 请求转发到ServletB
		// 1.使用request调用getRequestDispacher(path)
		request.setAttribute("name", "zhangsan");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sb");// -->http://localhost:8080/servlet02/

		/// 不可
		// RequestDispatcher dispatcher =
		/// request.getRequestDispatcher("http://www.baidu.com");
		// 2.执行转发,调用forward方法
		dispatcher.forward(request, response);
		System.out.println("结束");
		// request.getRequestDispatcher("index.html").forward(request,
		// response);
	}

}
