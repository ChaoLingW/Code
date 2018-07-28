package com.hpe.java.day0723;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TelManage {

	Scanner sc = new Scanner(System.in);
	
	Map<String, Telephone> map = new HashMap<>();
	// 添加
	public void addTel() {
		System.out.println("---------添加电话本--------");
		//调用addT()实现对信息的输入，并保存到Telephone对象中
		Telephone telephone = addT();

		// 保存到列表中
		map.put(telephone.getName(), telephone);
		System.out.println("添加成功");

	}

	// 删除
	public void delTel() {

		//从已经有电话本的元素中查看是否有此姓名的元素
		System.out.println("请输入查询的名字");
		
		String name = sc.nextLine();
		boolean flag = map.containsKey(name);
		
		if(flag){
			//删除
			System.out.println("确定吗？1(是)0(否)");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			if (choice == 1) {
				//移除
				map.remove(name);
				System.out.println("删除成功");
			} else if (choice == 0) {
				System.out.println("你取消了删除");
			} else {
				System.out.println("选择错误");
			}
		}
		else{
			System.out.println("没有此人");
		}

	}

	// 修改
	public void updateTel() {

		System.out.println("---------修改电话本--------");
		System.err.println("请输入要修改的姓名");

		String name = sc.nextLine();
		boolean flag = map.containsKey(name);
		
		if (flag) {
			
			Telephone telephone = map.get(name);
			map.remove(name);
			telephone = addT();
			map.put(telephone.getName(), telephone);
			System.out.println("修改成功");

		}
		else{
			System.out.println("没有这个人");
		}

	}

	// 查询全部
	public void selectAllTel() {
		// 遍历tel数组
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		
		while(iterator.hasNext()){
			String name = iterator.next();
			Telephone telephone = map.get(name);
			System.out.println(telephone);
		}
	}

	// 根据姓名查询
	
	public void selectTelByName() {

		System.out.println("请输入查询的名字");
		String name = sc.nextLine();
		Telephone telephone = map.get(name);
		System.out.println(telephone);
		
	}
	
	
	//重載
	public Telephone addT(){
		
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
}
