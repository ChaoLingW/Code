package com.emp.java;

import java.util.Scanner;

public class TestEMD {

	private static int holiday;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Employee[] ems = new Employee[10];
		int maxIndex = -1;
		boolean flag = true;

		while (flag) {

			System.out.println("|---------------|");
			System.out.println("|-----1 增加-----|");
			System.out.println("|-----2 删除-----|");
			System.out.println("|-----3 修改-----|");
			System.out.println("|-----4 查询-----|");
			System.out.println("|-----0 退出-----|");
			System.out.println("|---------------|");
			System.out.println("请选择业务");

			String str = sc.nextLine();
			int select = Integer.parseInt(str);

			switch (select) {

			case 1:
				maxIndex++;
				addEmployee(ems, maxIndex);
				break;
			case 2:
				delEmployee(ems);
				maxIndex--;
				break;
			case 3:
				updateEmployee(ems);
				break;
			case 4:
				queryEmployee(ems);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("输入错误");
				break;
			}
		}
	}

	public static void addEmployee(Employee[] ems, int maxIndex) {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		System.out.println("请输入员工编号");
		String ID = sc.nextLine();

		System.out.println("请输入员工姓名");
		String name = sc.nextLine();

		System.out.println("请输入员工职工（普通员工，经理，董事长）");
		String postition = sc.nextLine();

		System.out.println("请输入员工请假天数");
		int holiday = sc.nextInt();

		System.out.println("请输入员工基本工资");
		double salary = sc.nextDouble();

		if (postition.equals("普通员工")) {
			ems[maxIndex] = new CommonEmployee(ID, name, postition, holiday, salary);
		} 
		else if (postition.equals("经理")) {
			ems[maxIndex] = new Manager(ID, name, postition, holiday, salary);
		} 
		else if (postition.equals("董事长")) {
			ems[maxIndex] = new Director(ID, name, postition, holiday, salary);
		} 
		else {
			flag = false;
		}
		
		if (flag) {
			System.out.println("增加数据成功");
			ems[maxIndex].dispaly();
		}
		else{
			System.out.println("输入的职位错误");
		}
	}

	public static void delEmployee(Employee[] ems) {

		Scanner sc = new Scanner(System.in);

		int i = queryEmployee(ems);
		
		if(i == -1)
			return;
		
		ems[i] = null;
		
		for (i = 0; i < ems.length - 1; i++) {
			if (ems[i] == null) {
				ems[i] = ems[i + 1];
				ems[i + 1] = null;
			}
		}

		System.out.println("删除数据成功");
	}

	public static void updateEmployee(Employee[] ems) {

		int i = queryEmployee(ems);
		boolean flag = true;
		
		if(i == -1)
			return;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请重新输入员工信息");
		System.out.println("请输入员工编号");
		String ID = sc.nextLine();

		System.out.println("请输入员工姓名");
		String name = sc.nextLine();

		System.out.println("请输入员工职工（普通员工，经理，董事长）");
		String postition = sc.nextLine();

		System.out.println("请输入员工请假天数");
		int holiday = sc.nextInt();

		System.out.println("请输入员工基本工资");
		double salary = sc.nextDouble();

		if (postition.equals("普通员工")) {
			ems[i] = new CommonEmployee(ID, name, postition, holiday, salary);
		} 
		else if (postition.equals("经理")) {
			ems[i] = new Manager(ID, name, postition, holiday, salary);
		} 
		else if (postition.equals("董事长")){
			ems[i] = new Director(ID, name, postition, holiday, salary);
		}
		else{
			flag = false;
		}
		
		if(flag){
			System.out.println("修改数据成功");
			ems[i].dispaly();
		}
		else{
			System.out.println("输入职务有误");
		}
	}

	public static int queryEmployee(Employee[] ems) {

		Scanner sc = new Scanner(System.in);
		int index = -1;
		
		System.out.println("请输入员工姓名");
		String name = sc.nextLine();
	
		for (int i = 0; i < ems.length; i++) {
			if (ems[i] != null) {
				if (name.equals(ems[i].getName())) {
					ems[i].dispaly();
					index = i;
					break;
				}
			}
		}
		
		if(index == -1)
			System.out.println("没有该职工的信息");
		
		return index;
	}
}
