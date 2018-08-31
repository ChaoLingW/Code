package cn.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/three")
public class ThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("请求的方式："+ request.getMethod());
		System.out.println("请求的协议：" + request.getProtocol());
		System.out.println("请求的地址：" + request.getRequestURI());
		System.out.println("请求的主机：" + request.getHeader("host"));
		System.out.println("请求的来自：" + request.getHeader("Referer"));
		
		//如何构建：当前web应用的地址-->http://localhost:8080/servlet02/
		
		String http = request.getScheme();
		String host = request.getServerName();
		int port = request.getServerPort();
		String path = request.getContextPath();
		
		String bathPath = http + "://" + host + ":" + port + path + "/";
		System.out.println(bathPath);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
