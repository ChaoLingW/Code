package com.hpe.java.day0725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

public class TelManage {

	Scanner sc = new Scanner(System.in);
	List<String> list = new ArrayList<>();

	// 添加
	public void addTel() {
		System.out.println("---------添加电话本--------");

		Telephone telephone = addT();
		selectAllTel(null);
		list.add(telephone.toString());
		writer(list);

		System.out.println("添加成功");

	}

	// 删除
	public void delTel() {

		// 从已经有电话本的元素中查看是否有此姓名的元素
		System.out.println("请输入要删除的名字");

		String name = sc.nextLine();

		int index = selectAllTel(name);

		if (index != -1) {

			list.remove(index);
			writer(list);
			System.out.println("刪除成功");
		} else {
			System.out.println("此人不存在");
		}

	}

	// 修改
	public void updateTel() {
		System.out.println("---------修改电话本--------");
		System.err.println("请输入要修改的姓名");

		String name = sc.nextLine();

		int index = selectAllTel(name);

		if (index != -1) {

			Telephone telephone = addT();
			list.set(index, telephone.toString());
			writer(list);
			System.out.println("修改成功");
		} else {
			System.out.println("此人不存在");
		}

	}

	// 查询全部
	public void selectAllTel() {

		BufferedReader br = null;
		String res = null;

		try {
			br = new BufferedReader(new FileReader("tel.txt"));

			String str;
			while ((str = br.readLine()) != null) {

				System.out.println(str);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	// 根据姓名查询

	public void selectTelByName() {

		System.out.println("请输入查询的名字");
		String name = sc.nextLine();

		int index = selectAllTel(name);

		if (index != -1)
			System.out.println(list.get(index));
		else {
			System.out.println("此人不存在");
		}
	}

	// 重載
	public Telephone addT() {
		System.out.println("姓名：");
		String name = sc.nextLine();
		System.out.println("性别：");
		String sex = sc.nextLine();
		System.out.println("年龄：");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("电话：");
		String tel = sc.nextLine();
		System.out.println("Q Q：");
		String qq = sc.nextLine();
		System.out.println("地址：");
		String address = sc.nextLine();

		Telephone telephone = new Telephone(name, sex, age, tel, qq, address);

		System.out.println(telephone);

		return telephone;

	}

	// 写入
	public void writer(List<String> list) {

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("tel.txt", false));

			Iterator<String> iterator = list.iterator();
			
			while(iterator.hasNext()){
				bw.write(iterator.next());
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	// 查找
	public int selectAllTel(String name) {

		BufferedReader br = null;
		int index = -1;
		int count = 0;
		list.clear();
		
		try {
			br = new BufferedReader(new FileReader("tel.txt"));

			String str;
			while ((str = br.readLine()) != null) {
				list.add(str);
				if (name != null) {
					if (str.indexOf(name) != -1)
						index = count;
				}
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return index;
	}

}
