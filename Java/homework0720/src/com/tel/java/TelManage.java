package com.tel.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TelManage {

	Scanner sc = new Scanner(System.in);
	
	List<Telephone> telList = new ArrayList<Telephone>();//创建列表

	// 添加
	public void addTel() {
		System.out.println("---------添加电话本--------");
		//调用addT()实现对信息的输入，并保存到Telephone对象中
		Telephone telephone = addT();
		// 保存到列表中
		telList.add(telephone);
		System.out.println("添加成功");
	}

	// 删除
	public void delTel() {

		//从已经有电话本的元素中查看是否有此姓名的元素
		System.out.println("请输入查询的名字");
		
		String name = sc.nextLine();
		int index = selectTelByName(name);
		
		if(index != -1){
			//删除
			System.out.println("确定吗？1(是)0(否)");
			int choice = sc.nextInt();
			sc.nextLine();
			
			if (choice == 1) {
				//移除
				telList.remove(index);
				System.out.println("删除成功");
			} else if (choice == 0) {
				System.out.println("你取消了删除");
			} else {
				System.out.println("选择错误");
			}
		}
	}

	// 修改
	public void updateTel() {

		System.out.println("---------修改电话本--------");
		System.err.println("请输入要修改的姓名");

		String name = sc.nextLine();
		int index = selectTelByName(name);
		
		if (index != -1) {
			Telephone telephone = addT();
			telList.set(index, telephone);			
			System.out.println("修改成功");
		}
	}

	// 查询全部
	public void selectAllTel() {
		// 遍历tel数组
		Iterator<Telephone> iterator = telList.iterator();
		while(iterator.hasNext()){
			Telephone telephone = iterator.next();
			System.out.println(telephone);
		}
	}
	
	// 根据姓名查询
	public void selectTelByName() {

		System.out.println("请输入查询的名字");
		String name = sc.nextLine();
		selectTelByName(name);
	}
	
	// 重載
	// 参数：名字
	// 返回值：此名字的人的下标，如果没有就返回-1
	public int selectTelByName(String name) {

		int index = -1;
		Iterator<Telephone> iterator = telList.iterator();
		
		while(iterator.hasNext()){
			Telephone telephone = iterator.next();
			if(telephone.getName().equals(name)){
				System.out.println(telephone);
				index = telList.indexOf(telephone);
				break;
			}
		}
		if(index == -1)
			System.out.println("此人不存在");
		return index;
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
