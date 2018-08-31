package cn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class TwoFilter implements Filter {

    public TwoFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("OneFilter start");
		
		//放行 不一定到请求的资源，可能是下一个过滤器
		chain.doFilter(request, response);
		
		System.out.println("OneFilter end");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("init");
	}

}
