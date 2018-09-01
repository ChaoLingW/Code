package com.hpe.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileInputOutputStreamTest {
	
	//		  字节流(输入流)			    字节流(输出流)	   	   字符流(输入流) 	   字符流(输出流)
	//抽象基类  InputStream			  OutputStram			Reader			Writer	
	//节  点  流  FileInputStream 	  FileOutPutSteram	    FileReader  	FileWriter
	//缓  冲  流  BufferedInPutSteram  BufferedOutPutStram   BufferedReader  BufferedWriter
	
	@Test
	public void test1(){
		
		//复制-->先读后写
		
		FileInputStream fis = null;

		FileOutputStream fos = null;
		
		try {
			//1.创建FileInputStream的对象
			fis = new FileInputStream("1.png");
			//2.创建FileOutputStream的对象
			fos = new FileOutputStream("2.png");
			//3.边读边写
			byte[] b = new byte[1024];
			int len;
			
			while((len = fis.read(b)) != -1){
				//写入到2.png
				fos.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//4.释放资源
			try {
				//栈的顺序关闭
				if(fos != null)
					fos.close();
				if(fis != null)
					fis.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}
