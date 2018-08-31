package cn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		//什么时候放行-->登陆就放行-->session中有user属性
		//session
		Object user = req.getSession().getAttribute("user");
		if (user != null) {
			chain.doFilter(req, res);
		}
		
		else {
			res.sendRedirect(req.getContextPath() + "/index.jsp");
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
