package cn.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.util.CodeUtils;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应类型
		response.setContentType("image/jpeg");
		// 1.生成验证码
		String code = CodeUtils.generateVerifyCode(4);
		// 2.获取session
		HttpSession session = request.getSession();
		
		// 移除session中原来存储的验证码
		session.removeAttribute("code");
		// 3. 将验证码保存到session中
		session.setAttribute("code", code);
		// 4.将生成的验证码图片，通过字节流的方式响应回客户端
		CodeUtils.outputImage(100, 40, response.getOutputStream(), code);
	
	}

}
