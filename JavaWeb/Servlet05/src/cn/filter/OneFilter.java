package cn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * TODO 过滤器
 * 如何创建过滤器
 * implements Fileter,实现Filter接口中的抽象方法init/doFilter/destroy
 * 过滤器：单实例
 * 什么时候创建：当服务器加载web应用的时候，就创建这个实例，同时调用init
 * @author chaoling
 */
public class OneFilter implements Filter {

    public OneFilter() {
    	System.out.println("Constructor...");
    }

	public void destroy() {
		System.out.println("destory");
	}

	/**
	 * 每次请求都会调用
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("OneFilter start");
		System.out.println(request);
		
		//放行 不一定到请求的资源，可能是下一个过滤器
		chain.doFilter(request, response);
		
		System.out.println("OneFilter end");
	}

	/**
	 * 应用程序重新加载/服务器关闭
	 * FilterConfig：filter的配置信息，servletContext
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		String encoding = fConfig.getInitParameter("encoding");
		
		System.out.println(encoding);
		System.out.println("init");
	}

}
