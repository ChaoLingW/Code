package com.hpe.java2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class ThrowsTest {

	@Test
	public void test1() {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("111.txt");

			int a;

			while ((a = fis.read()) != -1) {
				System.out.print((char) a);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//throws抛出异常：在方法后写
	public void test2() throws IOException {

		FileInputStream fis = new FileInputStream("111.txt");

		int a;

		while ((a = fis.read()) != -1) {
			System.out.print((char) a);
		}

	}

	public void test3() throws IOException{
		test2();
	}
	
	@Test
	public void test4() throws IOException{
		test3();
	}
	
	@Test
	public void test5(){
		
		int a = 1;
		//throw
		throw new RuntimeException();
		
		
	}
	
}
