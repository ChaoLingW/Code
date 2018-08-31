package cn.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
	
		//用户名
		
		//密码
		
		//验证码
		String sCode = request.getParameter("vCode");
		
		//获取session
		HttpSession session = request.getSession();
		//得到session中保存的验证码
		String code = (String)session.getAttribute("code");
		//比较
		
		if(code == null){
			return;
		}
		if(code.equals(sCode)){
			System.out.println("登录成功");
			
		} else {
			System.out.println("登录失败");
		}
	
	}

}

