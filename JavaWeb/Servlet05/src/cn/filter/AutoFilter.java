package cn.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.po.User;


public class AutoFilter implements Filter {

    public AutoFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//实现自动登陆-->从request获取Cookie[]。遍历，查看 有名称是autoLogin的Cookie
		// 有的话，得到value-->split-->[]0 []1 -->解码-->验证是否正确
		//-->封装到user--> 添加到session
		//   /LoginServlet
		if( !"/LoginServlet".equals(req.getServletPath()) && (req.getSession().getAttribute("user") == null)){
			//什么时候自动登陆
			Cookie[] cookies = req.getCookies();
			if(cookies != null && cookies.length > 0){
				for(Cookie cookie : cookies){
					
					if("autoLogin".equals(cookie.getName())){
						String val = cookie.getValue();
						String[] vals = val.split("#");//[0]用户名 [1] 密码
						String name = URLDecoder.decode(vals[0],"utf-8");
						String pwd = URLDecoder.decode(vals[1],"utf-8");
						
						//验证
						if((name!=null &&!"".equals(name.trim()))&&(pwd!=null &&!"".equals(pwd.trim()))){
							
							//正确
							User user = new User();
							user.setName(name);
							user.setPwd(pwd);
							req.getSession().setAttribute("user", user);
							
						}
					}
					break;
				}
			}
			
			
		}
		
		chain.doFilter(req, res);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
