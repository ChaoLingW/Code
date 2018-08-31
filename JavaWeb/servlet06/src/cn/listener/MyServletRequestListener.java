package cn.listener;

import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("请求监听");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("监听销毁");
	}

}
