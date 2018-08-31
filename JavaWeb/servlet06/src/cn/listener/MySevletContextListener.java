package cn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySevletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("servletContext 被创建");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("servletContext 被销毁");
		
	}

}
