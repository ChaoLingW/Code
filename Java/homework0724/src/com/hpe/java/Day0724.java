package com.hpe.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Day0724 {

	/*
	 * 使用字节流完成以下操作 
	 * 1. 在当前工程下新建一个文件 "test.txt"，利用程序在文件中写入如下内容： 
	 * 七夕 作者：徐凝 一道鹊桥横渺渺，千声玉佩过玲玲。 别离还有经年客， 怅望不如河鼓星。
	 */
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
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/*
	 * 2. 利用程序读取 test.txt 文件的内容, 并在控制台打印
	 */
	@Test
	public void test2() {

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

	/*
	 * 3. 利用程序复制 test.txt ，保存到 test1.txt中（选做）
	 */
	@Test
	public void test3() {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("test1.txt");

			byte[] b = new byte[10];
			int len;

			while ((len = fis.read(b)) != -1) {
				for (int i = 0; i < len; i++)
					fos.write(b[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
