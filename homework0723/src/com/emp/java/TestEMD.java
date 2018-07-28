package com.emp.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestEMD {

	private static final String CommonEmployee = null;
	private static int holiday;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Employee> map = new HashMap<>();

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
				addEmployee(map);
				break;
			case 2:
				delEmployee(map);
				break;
			case 3:
				updateEmployee(map);
				break;
			case 4:
				queryEmployee(map);
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

	public static void addEmployee(Map<String, Employee> map) {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		Employee employee = add();

		if(!employee.equals(null)){
			
			map.put(employee.getName(), employee);
			employee.dispaly();
			System.out.println("增加数据成功");

		} else {
			System.out.println("添加数据失败");
		}
	}

	public static void delEmployee(Map<String, Employee> map) {

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入要删除人的姓名");

		String name = sc.nextLine();

		boolean flag = map.containsKey(name);

		if (flag) {
			map.remove(name);
			System.out.println("删除数据成功");
		} else {
			System.out.println("没有这个人");
		}

	}

	public static void updateEmployee(Map<String, Employee> map) {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要修改的人的姓名");

		String name = sc.nextLine();

		boolean flag = map.containsKey(name);

		if (flag) {
			System.out.println("请重新输入员工信息");

			Employee employee = map.get(name);
			if (!employee.equals(null)) {
				employee = add();
				System.out.println("修改数据成功");
			}else{
				System.out.println("输入失败");
			}
		} else {
			System.out.println("修改数据失败");
		}

	}

	public static void queryEmployee(Map<String, Employee> map) {

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入员工姓名");
		String name = sc.nextLine();

		boolean flag = map.containsKey(name);

		if (flag) {
			Employee employee = map.get(name);
			employee.dispaly();

		} else {
			System.out.println("没有这个人");
		}
	}

	public static Employee add() {

		Scanner sc = new Scanner(System.in);

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
		Employee employee = new Employee();

		if (postition.equals("普通员工")) {
			employee = new CommonEmployee(ID, name, postition, holiday, salary);

		} else if (postition.equals("经理")) {
			employee = new Manager(ID, name, postition, holiday, salary);
		} else if (postition.equals("董事长")) {
			employee = new Director(ID, name, postition, holiday, salary);
		} else {
			System.out.println("输入的职位错误");
		}
		return employee;
	}
}
