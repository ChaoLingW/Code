package cn.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/four")
public class FourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//响应的内容为图片的html
		//如果直接访问此servlet，响应内容为超链接(链接到index.html)
		response.setContentType("text/html;charset=utf=8");
		PrintWriter out = response.getWriter();
	
		String refer = request.getHeader("Referer");
		
		if(refer== null){
			//直接访问
			out.write("<a href='index.html'>index</a>");
		} else {
			out.write("<img src='"+ request.getContextPath() +"/11.jpg' />");
		}
	
	}

}
