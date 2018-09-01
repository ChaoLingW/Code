package com.hpe.exec.jiangjie0717;

import java.util.Scanner;

public class TelManage {

	Scanner sc = new Scanner(System.in);
	Telephone[] tels = new Telephone[100];
	int max = 0;// 下一个telephone对象，要存到数组的哪个元素的对应下标

	// 添加
	public void addTel() {
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

		// 保存到数组中
		tels[max] = telephone;
		max++;
		System.out.println("添加成功");

	}

	// 删除
	public void delTel() {
		boolean flag = true;
		System.out.println("请输入删除的名字");

		String name = sc.nextLine();

		for (int i = 0; i < max; i++) {

			// 判断，如果当前这个人的名字跟我输入的一致，删除
			if (tels[i].getName().equals(name)) {
				// 找到//删除
				// 当前数组中最后一个有值的元素的下标为max-1
				System.out.println(tels[i]);
				System.out.println("确定吗？1(是)0(否)");
				int choice = sc.nextInt();
				sc.nextLine();
				if (choice == 1) {
					for (; i <= max - 2; i++) {
						tels[i] = tels[i + 1];
						max--;
						System.out.println("删除成功");
						flag = false;// 不会进入if
						break;
					}

				} else if (choice == 0) {
					System.out.println("你取消了删除");
					return;
				} else {
					System.out.println("选择错误");
					return;
				}

			}
		}
		if (flag) {
			// 如果不存在，打印此人不存在
			System.out.println("此用户不存在");
		}

	}

	// 修改
	public void updateTel() {

		System.out.println("---------修改电话本--------");
		System.err.println("请输入要修改的姓名");

		String str = sc.nextLine();
		int index = -1;
		for (int i = 0; i < max; i++) {

			// 判断，如果当前这个人的名字跟我输入的一致，删除
			if (tels[i].getName().equals(str)) {
				index = 0;
			}
		}
		if (index == -1) {
			System.out.println("此人不存在");
		} else {
			System.out.println(tels[index]);
			System.out.println("请输入信息");
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

			// 保存到数组中
			tels[index] = telephone;
			
			System.out.println("修改成功");

		}

	}

	// 查询全部
	public void selectAllTel() {
		// 遍历tel数组
		for (int i = 0; i < max; i++) {
			System.out.println(tels[i]);
		}
	}

	// 根据姓名查询
	public void selectTelByName() {

		System.out.println("请输入查询的名字");
		String name = sc.nextLine();

		for (int i = 0; i < max; i++) {
			// 判断，如果当前这个人的名字跟输入的一致，输出
			if (tels[i].getName().equals(name)) {
				System.out.println(tels[i]);
				return;
			}
		}
		System.out.println("此人不存在");
	}
}
