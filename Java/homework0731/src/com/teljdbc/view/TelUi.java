package com.teljdbc.view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.teljdbc.po.Telephone;
import com.teljdbc.service.TelService;

public class TelUi {

	static Scanner sc = new Scanner(System.in);
	static TelService telService = new TelService();

	public static void main(String[] args) {

		while (true) {

			menu();

			String choice = sc.nextLine();

			// 判断输入
			switch (choice) {

			case "1":
				// 添加
				addTel();
				break;

			case "2":
				// 删除
				delTel();
				break;

			case "3":
				// 修改
				updateTel();
				break;

			case "4":
				// 查询全部
				selectAllTel();
				break;

			case "5":
				// 根据姓名查询
				selectTelByName();
				break;

			case "0":
				// 退出
				exit();
				break;

			default:
				System.out.println("输入有误，请重新输入");
				break;
			}
		}
	}

	/**
	 * @Description: 显示菜单
	 */
	private static void menu() {
		System.out.println("----------------电话本管理系统----------------");
		System.out.println("1.添加\t2.删除\t3.修改\t4.查询所有\t5.根据姓名查询\t0.退出");
		System.out.println("----------------电话本管理系统----------------");
		System.out.print("请选择业务：");
	}

	/**
	 * @Description: 添加显示
	 */
	private static void addTel() {

		System.out.println("---------添加电话本--------");
		Telephone telephone = info(0, "add");
		if (telephone == null) {
			System.out.println("此用户已存在，不能添加");
			return;
		}
		System.out.println(telephone);

		// 调用TelService中addTel(),传入Telephone，接收返回值;
		boolean addRes = telService.addTel(telephone);
		if (addRes)
			System.out.println("添加成功");
		else
			System.out.println("添加失败");
	}

	/**
	 * @Description: 删除显示
	 */
	private static void delTel() {

		System.out.println("---------删除电话本--------");
		System.out.println("请输入要删除人的姓名");

		int res = telService.deleteTelByName(sc.nextLine());

		if (res == 1)
			System.out.println("删除成功");
		else if (res == 0)
			System.out.println("删除失败");
		else
			System.out.println("此人不存在");
	}

	/**
	 * @Description: 修改显示  
	 */
	private static void updateTel() {

		System.out.println("---------修改电话本--------");
		System.out.println("请输入要修改人的姓名");

		String name = sc.nextLine();
		// 判断是否存在
		Telephone isExist = telService.selectTelByName(name);
		// 为-1则不存在
		if (isExist == null)
			System.out.println("此名称的电话本不存在，无法修改");
		else {

			Telephone telephone = info(isExist.getId(), "update");

			if (telephone == null)
				System.out.println("此新名称已存在，不可以使用此名称修改");
			else {

				telephone.setId(isExist.getId());
				boolean updateRes = telService.updateTel(telephone);

				if (updateRes)
					System.out.println("修改成功");
				else
					System.out.println("修改失败");
			}
		}
	}

	/**
	 * @Description: 查询所有显示
	 */
	private static void selectAllTel() {

		System.out.println("---------查询所有电话本--------");
		// 调用TelService中selectAllTel(),得到所有电话本
		List<Telephone> tels = telService.selectAllTel();

		if(tels != null && tels.size() != 0)
		// 遍历显示所有电话
		for (Telephone telephone : tels)
			System.out.println(telephone);
	}

	/**
	 * @Description: 根据姓名查询显示
	 */
	private static void selectTelByName() {

		System.out.println("---------根据姓名查询--------");
		System.out.println("请输入要查询姓名");
		// 调用TelService中selectTelByName(),传name
		Telephone telephone = telService.selectTelByName(sc.nextLine());
		// 判断
		if (telephone == null)
			// 不等于null 打印电话本
			System.out.println("此人不存在");
		else
			System.out.println(telephone);

	}

	/**
	 * @Description: 接受输入
	 * @param oldId
	 * @param grant
	 * @return null 姓名已存在  
	 */
	private static Telephone info(int oldId, String grant) {

		System.out.println("姓名：");
		String name = sc.nextLine();

		// 如果是添加，根据姓名查询，若返回值不为null，则该名字存在，即不可添加 返回null
		if (grant.equals("add"))
			if (telService.selectTelByName(name) != null)
				return null;
		// 如果是修改，根据姓名查询，若返回值不为空，且新的姓名的id与原姓名的id不等，说明重复，返回null
		if (grant.equals("update")) {
			if (telService.selectTelByName(name) != null) {
				int newId = telService.selectTelByName(name).getId();
				if (newId != oldId)
					return null;
			}
		}

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

		Telephone telephone = new Telephone(0, name, sex, age, tel, qq, address);

		return telephone;
	}

	/**
	 * @Description: 退出显示 
	 */
	private static void exit() {
		System.out.println("谢谢使用，再见");
		System.exit(0);
	}
	
}
