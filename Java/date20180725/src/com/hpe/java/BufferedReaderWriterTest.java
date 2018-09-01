package com.hpe.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class BufferedReaderWriterTest {

	@Test
	public void testBufferedReader(){
		
		//BufferedReader 输入流、字符流、处理流
		//File
		File file = new File("hello.txt");
		//FileReader
		FileReader fr = null;
		//BufferedReader
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String str;//保存每一行的内容
			
			while((str = br.readLine()) != null){
				//打印这一行数据
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void testBufferWriter(){
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("3.txt"));
			
			bw.write("hello World !");
			bw.newLine();//换行
			bw.write("星期三");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void copy(){
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("hello.txt"));
			bw = new BufferedWriter(new FileWriter("hello3.txt"));
			
			String str;
			while((str = br.readLine()) != null){
				//写
				bw.write(str);
				//换行
				bw.newLine();
				//清空缓存区
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null)
					bw.close();
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
