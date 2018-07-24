package com.hpe.java3;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

//File:与平台无关的文件或者目录
//File能新建、删除、重命名文件和目录，但File不能访问文件内容本身。
//如果需要访问文件内容，需要输入/输出流
public class FileTest {

	@Test
	public void test1(){
		
		//相对路径:相对于当前工程的路径
		//绝对路径:带着盘符的
		File file = new File("D:\\1.txt");
		
		File file1 = new File("D:\\1");
		
		//getName()获取文件名或目录名
		String name = file.getName();
		System.out.println(name);
		
		System.out.println(file1.getName());
		
		File file2 = new File("2.txt");//相对路径
		
	}
	
	@Test
	public void test2(){
		
		File file = new File("D:/1.txt");
		File file1 = new File("D:/1");
		
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());//String
		System.out.println(file.getAbsoluteFile());//File
		System.out.println(file.getParent());
		
		System.out.println();
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsolutePath());//String
		System.out.println(file1.getAbsoluteFile());//File
		System.out.println(file1.getParent());
	
		//剪切重命名： file.renameTo(fileNewName)
		//file必须存在，fileNewName不存在
		
		File file3 = new File("D:/2.txt");
		
		System.out.println(file.renameTo(file3));
		
		File file4 = new File("D:/3.txt");
		
		System.out.println(file4.exists());
		System.out.println(file.isFile());
		
	}
	
	@Test
	public void test3() throws IOException{
		
		File file = new File("D:/11.txt");
		
		if(!file.exists()){
			//创建
			file.createNewFile();
		}
		
		File file1 = new File("D:/2");
		
		if(!file1.exists()){
			file1.mkdirs();
		}
		
		File file2 = new File("D:/");
		String[] list = file2.list();
		
		for(String str:list)
			System.out.println(str);
		
	}
	
}
