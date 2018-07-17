package com.hpe.exec.jiangjie0717;

import java.util.Scanner;

public class TelManage {

	Scanner sc = new Scanner(System.in);
	Telephone[] tels = new Telephone[100];
	int max = 0;//下一个telephone对象，要存到数组的哪个元素的对应下标
	//添加
	public void addTel(){
		System.out.println("---------添加电话本--------");
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
		
		//保存到数组中
		tels[max] = telephone;
		max++;
		System.out.println("添加成功");
		
		
	}
	
	//删除
	public void delTel(){
		boolean flag = true;
		System.out.println("请输入删除人的名字");
		
		String name = sc.nextLine();
		
		for(int i =0; i < max; i++){
			//tels[i]
			
			
			//判断，如果当前这个人的名字跟我输入的一致，删除
			if(tels[i].getName().equals(name)){
				//找到
				//删除
				//当前数组中最后一个有值的元素的下标为max-1
				for(;i<=max-2;i++){
					tels[i] = tels[i+1];
				}
				max--;
				System.out.println("删除成功");
				flag = false;//不会进入if
				break;
			}
		}
		if(flag){
			
			//如果不存在，打印此人不存在
			System.out.println("此用户不存在");
		}
		
		
	}
	//修改
	public void updateTel(){
		
	}
	//查询全部
	public void  selectAllTel(){
		//遍历tel数组
		for(int i =0; i < max;i++){
			System.out.println(tels[i]);
		}
	}
	//根据姓名查询
	public void selectTelByName(){
		
	}
}
