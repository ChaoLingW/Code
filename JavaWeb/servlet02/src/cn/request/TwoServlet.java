package cn.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/two")
public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//8.0版本之后已经被处理了
		String name = request.getParameter("username");
		System.out.println(name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*// 解决乱码方式一
		String username = request.getParameter("username");// ISO-8859-1编码的中文
		// 得到iso-8859-1所对应的字节码
		byte[] bytes = username.getBytes("iso-8859-1");
		// 再使用utf-8进行编码，得到正确数据
		String newUserName = new String(bytes,"utf-8");
		System.out.println(username);
		System.out.println(newUserName);*/
		
		//解决乱码方式二：重要(注意：只对post方式有用)
		//对于post请求，在获取数据之前，使用request调用setCharacterEncoding方法设置编码
		request.setCharacterEncoding("utf-8");//一定要在获取数据之前
		String name = request.getParameter("username");
		System.out.println(name);
		
	}

}
