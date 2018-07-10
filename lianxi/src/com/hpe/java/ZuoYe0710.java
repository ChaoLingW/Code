package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月10日下午8:40:53
 * @Description
 */
public class ZuoYe0710 {

	public static void main(String[] args) {

		Person[] person = new Person[10];
		new ZuoYe0710().select(person);

	}

	public void index() {

		System.out.println("--------------------电话本管理系统----------------");
		System.out.println("1.添加   2.删除   3.修改   4.查询所有  5.根据姓名查询    0.退出");
		System.out.println("--------------------电话本管理系统----------------");

	}

	public void select(Person[] person) {
		int i = 0;
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		while (flag) {

			index();

			System.out.println("请选择业务");

			int select = sc.nextInt();

			switch (select) {

			case 1:
				insert(person, i);
				i++;
				break;
			case 2:
				delete(person);
				i--;
				break;

			case 3:
				alter(person);
				break;
			case 4:
				searchAll(person);
				break;
			case 5:
				searchOfName(person);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("输入错误！请重新输入");
				break;
			}

		}

	}

	public void insert(Person[] p, int i) {

		Scanner sc = new Scanner(System.in);

		System.out.println("----------添加电话本----------");
		System.out.print("姓名：");
		String name = sc.nextLine();
		System.out.print("性别：");
		String sex = sc.nextLine();
		System.out.print("年龄：");
		String age = sc.nextLine();
		System.out.print("电话：");
		String phone = sc.nextLine();
		System.out.print("QQ：");
		String qq = sc.nextLine();
		System.out.print("地址：");
		String addr = sc.nextLine();

		System.out.println("姓名：" + name + ",性别：" + sex + "，年龄：" + age + "，电话：" + phone + "，Q Q：" + qq + ".地址：" + addr);
		p[i] = new Person(name, sex, age, phone, qq, addr);

		System.out.println("添加成功");

	}

	public void delete(Person[] person) {

		boolean flag = true;
		System.out.println("--------------------删除电话本----------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入姓名");
		String name = sc.nextLine();
		for (int i = 0; i < person.length; i++) {
			if (person[i] != null) {

				if (person[i].getName().equals(name)) {
					System.out.println("姓名：" + person[i].getName() + ",性别：" + person[i].getSex() + "，年龄："
							+ person[i].getAge() + "，电话：" + person[i].getPhone() + "，Q Q：" + person[i].getQq() + ".地址："
							+ person[i].getAddr());
					System.out.println("确定吗？1（是）0（否）");
					int select = sc.nextInt();
					if (select == 1) {
						flag = false;
						person[i] = null;
						System.out.println("删除成功");
						break;
					} else {
						System.out.println("你选择了否");
						break;
					}

				}

			}

		}

		if (flag) {
			System.out.println("此人不存在");
		} else {
			/*for (int i = 0; i < person.length - 1; i++) {

				if (person[i] == null) {
					person[i] = person[i + 1];
				}

			}*/
		}

	}

	public void alter(Person[] person) {

		boolean flag = true;
		System.out.println("--------------------修改电话本----------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入姓名");
		String name = sc.nextLine();
		int index = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i]!= null) {
				if (person[i].getName().equals(name)) {
					System.out.println("姓名：" + person[i].getName() + ",性别：" + person[i].getSex() + "，年龄："
							+ person[i].getAge() + "，电话：" + person[i].getPhone() + "，Q Q：" + person[i].getQq() + ".地址："
							+ person[i].getAddr());
					flag = false;
					i = index;
					break;
				}
			}
		}

		if (flag) {
			System.out.println("此人不存在");
		} else {
			System.out.print("姓名：");
			String name1 = sc.nextLine();
			System.out.print("性别：");
			String sex = sc.nextLine();
			System.out.print("年龄：");
			String age = sc.nextLine();
			System.out.print("电话：");
			String phone = sc.nextLine();
			System.out.print("QQ：");
			String qq = sc.nextLine();
			System.out.print("地址：");
			String addr = sc.nextLine();

			System.out.println(
					"姓名：" + name1 + ",性别：" + sex + "，年龄：" + age + "，电话：" + phone + "，Q Q：" + qq + ".地址：" + addr);
			person[index] = new Person(name1, sex, age, phone, qq, addr);

			System.out.println("修改成功");

		}
	}

	public void searchAll(Person[] person) {

		System.out.println("--------------------打印所有电话本----------------");
		for (Person p : person) {
			if (p != null)
				System.out.println("姓名：" + p.getName() + ",性别：" + p.getSex() + "，年龄：" + p.getAge() + "，电话："
						+ p.getPhone() + "，Q Q：" + p.getQq() + ".地址：" + p.getAddr());
		}

	}

	public void searchOfName(Person[] person) {

		boolean flag = true;
		System.out.println("--------------------查找电话本----------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入姓名");
		String name = sc.nextLine();
		for (Person p : person) {
			if (p != null) {
				if (p.getName().equals(name)) {
					System.out.println("姓名：" + p.getName() + ",性别：" + p.getSex() + "，年龄：" + p.getAge() + "，电话："
							+ p.getPhone() + "，Q Q：" + p.getQq() + ".地址：" + p.getAddr());
					flag = false;
					break;
				}
			}

		}

		if (flag) {
			System.out.println("此人不存在");
		}

	}

	class Person {

		private String name;
		private String sex;
		private String age;
		private String phone;
		private String qq;
		private String addr;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getQq() {
			return qq;
		}

		public void setQq(String qq) {
			this.qq = qq;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		
		public Person(String name, String sex, String age, String phone, String qq, String addr) {
			super();
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.phone = phone;
			this.qq = qq;
			this.addr = addr;
		}

		public Person() {
			super();
		}

	}

}
