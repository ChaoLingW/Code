package com.hpe.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class TCPTest {

	// 客户端发送数据，服务端数据并显示
	// 客户端
	@Test
	public void client() {

		Socket socket = null;
		OutputStream os = null;
		try {
			// 1.创建一个一个Socket对象，通过构造器指定服务端的ip,以及接收程序的端口号
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
			// 2.通过socket获得io流（输出流）
			os = socket.getOutputStream();
			// 3.执行io操作（写）
			os.write("我是客户端".getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.释放资源
				if (os != null)
					os.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 服务端
	@Test
	public void server() {

		ServerSocket serverSocket = null;
		Socket s = null;
		InputStream is = null;
		
		try {
			// 1.创建ServerSocke的对象，通过构造器指明自己的端口号，用户监听客户端的请求
			serverSocket = new ServerSocket(8989);
			// 2.调用accept方法监听，监听客户端的请求，如果客户端请求连接，返回一个已连接的套接字
			s = serverSocket.accept();
			// 3.调用socket的getInputStream方法获取客户端发送过来的输入流
			is = s.getInputStream();
			// 4.对输入流的操作
			byte[] b = new byte[20];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
				if (s != null)
					s.close();
				if (serverSocket != null)
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
