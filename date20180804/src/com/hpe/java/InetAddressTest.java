package com.hpe.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * @Description:TODO
 * @author chaoling
 * @date 2018年8月4日
 */
public class InetAddressTest {

	/*
	 * 网络通信的第一要素：Ip地址，通过ip地址，就可以唯一的定位互联网上的一台主机
	 * InetAddress:java.net包
	 * InetAddress用来表示Ip地址，一个InetAddress的对象就代表一个ip地址
	 * 如何创建InetAddress的对象：getByName(String host) 
	 * getByName(host) 获取域名对应的Ip
	 * getHostName() 获取Ip地址对应的域名
	 * getHostAddress():获取ip地址
	 * getLocalHost()：获取本机ip地址
	 * 
	 * 
	 */
	
	@Test
	public void test1() throws UnknownHostException{
		
		
		InetAddress address = InetAddress.getByName("www.baidu.com");
		
		System.out.println(address);
		
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());

		InetAddress myAddress = InetAddress.getLocalHost();
		System.out.println(myAddress);
		System.out.println(myAddress.getHostName());
		System.out.println(myAddress.getHostAddress());
		
		
		
	}
}
