package com.hpe.java;

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

public class TelManage {

	Scanner sc = new Scanner(System.in);
	List<Telephone> list = new ArrayList<>();

	// 添加
	public void addTel() {
		System.out.println("---------添加电话本--------");
		//获取添加信息并添加到list中
		list.add(addT());
		System.out.println("添加成功");
	}

	// 删除
	public void delTel() {

		// 从已经有电话本的元素中查看是否有此姓名的元素
		System.out.println("请输入要删除的名字");

		//判断是否存在
		Telephone telephone= isExistence();
		//存在
		if (telephone!= null) {
			//移除
			list.remove(telephone);
			System.out.println("刪除成功");
		}
	}

	// 修改
	public void updateTel() {
		
		System.out.println("---------修改电话本--------");
		System.err.println("请输入要修改的姓名");

		//判断此人是否存在
		Telephone telephone = isExistence();
		//存在
		if (telephone != null) {
			//获取修改信息
			//修改对应的list
			list.set(list.indexOf(telephone), addT());
			System.out.println("修改成功");
		}
	}

	// 查询全部
	public void selectAllTel() {

		//遍历list
		for(Telephone telephone :list)
			telephone.display();
	}

	// 根据姓名查询
	public void selectTelByName() {

		System.out.println("请输入查询的名字");
		
		//判断此人是否存在，用res接收返回值
		Telephone telephone = isExistence();
		//不为空，存在，输出结果
		if(telephone != null)
			telephone.display();
	}

	// 获取控制台输入的个人信息
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
		telephone.display();
		return telephone;

	}

	// 写入
	public void writer() {

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("tel.txt", false));
			//遍历list 并对中的每个对象写入到文本中
			Iterator<Telephone> iterator = list.iterator();
			
			while(iterator.hasNext()){
				bw.write(iterator.next().toString());
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

	// 读出
	public void reader() {

		BufferedReader br = null;
		//只用一次读入的话是不需要对列表清除数据的
		//若多次读的话必须清除list的数据，否则会出想重复数据
		//list.clear();
		try {
			br = new BufferedReader(new FileReader("tel.txt"));

			//保存读出的数据
			String str = null;
			while ((str = br.readLine()) != null) {
				//拆分字符串
				String[] arr = str.split(",");
				//构造Telephone实例
				Telephone telephone = new Telephone(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3],arr[4], arr[5]);
				
				//添加到列表中
				list.add(telephone);
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
	
	//判断此人是否存在
	//返回值   存在 返回此人所在行的字符串
	//		不存在 返回null
	public Telephone isExistence(){
		
		String name = sc.nextLine();
		
		String str = null;
		Telephone telephone = new Telephone();
		//遍历查找
		for(int i = 0;i < list.size(); i++){
			//获取list中的每个字符串
			telephone = list.get(i);
			//判断，name
			if(telephone.getName().equals(name)){
				//存在就返回这个字符串
				return telephone; 
			}
		}
		//不存在，输出此人不存在
		System.out.println("此人不存在");
		//返回 此时返回值为null
		return null;
	}

}
