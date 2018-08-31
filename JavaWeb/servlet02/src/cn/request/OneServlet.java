package cn.request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO 接收用户参数
 * 
 * @author chaoling
 *
 */
@WebServlet("/one")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	// request:封装了请求信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getParameter(String)方法
		// 根据名字(name)获取一个参数，返回类型为String,如果无此参数，返回null
		String name = request.getParameter("name");
		System.out.println(name);

		// getParameterValues(String)方法
		// 根据名字获取一组相关的数据，返回类型为String[]
		String[] hobbys = request.getParameterValues("hobby");

		if (hobbys != null) {
			for (String hobby : hobbys) {
				System.out.println(hobby);
			}
		}

		// getParameterNames ()方法
		// 获取所有参数的名字，返回类型为Enumeration

		Enumeration<String> names = request.getParameterNames();
		
		while(names.hasMoreElements()){
			String name1 = names.nextElement();//
			
		}

		// getParameterMap ()方法 获取所有数据
		// 返回类型为Map
		Map<String, String[]> map = request.getParameterMap();
		
		Set<Entry<String,String[]>> entrys = map.entrySet();
		
		for(Entry<String,String[]> entry : entrys){
			String key = entry.getKey();
			String[] values = entry.getValue();
			
			for(String value : values){
				System.out.println(key + " " + value);
			}
		}
		

	}

}
