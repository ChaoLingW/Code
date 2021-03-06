package com.emp.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestEMD {

	private static int holiday;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
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
				addEmployee(list);
				break;
			case 2:
				delEmployee(list);
				break;
			case 3:
				updateEmployee(list);
				break;
			case 4:
				queryEmployee(list);
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

	public static void addEmployee(List<Employee> list) {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		Employee employee = add();

		if (employee.getPostition().equals("普通员工") || employee.getPostition().equals("经理")
				|| employee.getPostition().equals("董事长")) {
			list.add(employee);
		} else {
			flag = false;
		}

		if (flag) {
			int index = list.indexOf(employee);
			list.get(index).dispaly();
			System.out.println("增加数据成功");
		} else {
			System.out.println("输入的职位错误");
		}
	}

	public static void delEmployee(List<Employee> list) {

		Scanner sc = new Scanner(System.in);
		int index = queryEmployee(list);

		if (index == -1)
			return;
		list.remove(index);

		System.out.println("删除数据成功");
	}

	public static void updateEmployee(List<Employee> list) {

		boolean flag = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("请重新输入员工信息");

		int index = queryEmployee(list);
		if (index == -1) {
			return;
		}
		
		Employee employee = add();

		if (employee.getPostition().equals("普通员工") || employee.getPostition().equals("经理")
				|| employee.getPostition().equals("董事长")) {
			list.add(employee);
		} else {
			flag = false;
		}

		if (flag) {
			index = list.indexOf(employee);
			list.get(index);
			System.out.println("修改数据成功");
		} else {
			System.out.println("输入的职位错误");
		}

	}

	public static int queryEmployee(List<Employee> list) {

		Scanner sc = new Scanner(System.in);
		int index = -1;

		System.out.println("请输入员工姓名");
		String name = sc.nextLine();

		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			Employee next = iterator.next();
			if (next.getName().equals(name)) {
				index = list.indexOf(next);
				break;
			}
		}

		if (index == -1) {
			System.out.println("没有该职工的信息");
		} else {
			list.get(index).dispaly();
		}

		return index;
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

		Employee employee = new Employee(ID, name, postition, holiday, salary);

		return employee;
	}
}
