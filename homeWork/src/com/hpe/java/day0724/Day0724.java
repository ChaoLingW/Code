package com.hpe.java.day0724;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Day0724 {

	@Test
	public void test1() {

		String str = "七夕\n作者：徐凝\n一道鹊桥横渺渺，\n千声玉佩过玲玲。\n别离还有经年客，\n怅望不如河鼓星。";
		byte[] bytes = str.getBytes();

		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("test.txt");

			fos.write(bytes);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	@Test
	public void test2(){
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
			byte[] b = new byte[1000];
			int len;
			while ((len = fis.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void test3(){
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("test1.txt");
			
			byte[] b = new byte[10];
			
			int len;
			
			while((len = fis.read(b)) != -1){
				
				for(int i = 0; i < len; i ++)
					fos.write(b[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)
					fis.close();
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	
	
}
