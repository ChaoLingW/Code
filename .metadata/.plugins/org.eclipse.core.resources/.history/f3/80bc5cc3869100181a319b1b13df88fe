package com.hpe.java3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileOutStreamTest {

	@Test
	public void test1() {
		// 向hello1.txt中写入abc
		// FileOutputSteam 输出流，字节流，节点流

		FileOutputStream fos = null;

		try {
			File file = new File("hello1.txt");

			fos = new FileOutputStream(file);

			String str = "uuuu";
			byte[] bytes = str.getBytes();

			fos.write(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	@Test
	public void test2() {
		// 向hello1.txt中写入abc
		// FileOutputSteam 输出流，字节流，节点流

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("a.txt",true);//true, 追加

			String str = "uuuu";
			byte[] bytes = str.getBytes();

			fos.write(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
