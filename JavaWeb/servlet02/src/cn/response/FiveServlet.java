package cn.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/five")
public class FiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//设置响应内容类型
		response.setContentType("text/html;charset=utf-8");
		//字符流输出内容
//		PrintWriter out = response.getWriter();
//		out.write("今天是七夕");
		
		//字节流输出内容
		ServletOutputStream out1 = response.getOutputStream();
		out1.write("今天是好日子".getBytes());
	
		
	
	}

}
