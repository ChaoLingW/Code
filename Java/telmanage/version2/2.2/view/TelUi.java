package com.tel.view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.tel.po.Telephone;
import com.tel.service.TelService;

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
				System.out.println("谢谢使用");
				System.exit(0);
				break;

			default:
				System.out.println("输入有误，请重新输入");
				break;
			}
		}
	}

	// 显示菜单
	private static void menu() {
		System.out.println("----------------电话本管理系统----------------");
		System.out.println("1.添加\t2.删除\t3.修改\t4.查询所有\t5.根据姓名查询\t0.退出");
		System.out.println("----------------电话本管理系统----------------");
		System.out.print("请选择业务：");
	}

	private static void addTel() {
		// 完成添加的显示
		System.out.println("---------添加电话本--------");
		// 调用addT()实现对信息的输入，并保存到Telephone对象中
		Telephone telephone = createTel(0);
		if(telephone == null){
			System.out.println("此用户已存在，不能添加");
			return;
		}
		System.out.println(telephone);

		// 调用TelService中addTel(),传入Telephone，接收返回值;
		boolean addRes = telService.addTel(telephone);
		if (addRes )
			System.out.println("添加成功");
		else
			System.out.println("添加失败");

	}

	private static void delTel() {

		System.out.println("---------删除电话本--------");
		System.out.println("请输入要删除人的姓名");
		boolean isDel = telService.deleteTelByName(sc.nextLine());

		if (isDel)
			System.out.println("删除成功");
		else
			System.out.println("此人不存在");

	}

	private static void updateTel() {

		System.out.println("---------修改电话本--------");
		System.out.println("请输入要修改人的姓名");
		
		String name = sc.nextLine();
		//判断是否存在
		int index = telService.selectIndexByName(name);
		//为-1则不存在
		if (index == -1)
			System.out.println("此名称的电话本不存在，无法修改");
		else {
			Telephone telephone = createTel(index);
			
			if(telephone == null){
				System.out.println("此新名称已存在，不可以使用此名称修改");
			}else{
				boolean updateRes = telService.updateTel(telephone,index);
				if (updateRes)
					System.out.println("修改成功");
				else
					System.out.println("修改失败");
			}
		}
	}

	private static void selectAllTel() {

		System.out.println("---------查询所有电话本--------");
		// 调用TelService中selectAllTel(),得到所有电话本
		List<Telephone> tels = telService.selectAllTel();

		// 遍历显示所有电话
		for (Telephone tel : tels)
			System.out.println(tel);
	}

	private static void selectTelByName() {

		System.out.println("---------根据姓名查询--------");
		System.out.println("请输入要查询姓名");
		// 调用TelService中selectTelByName(),传name
		Telephone telephone = telService.selectTelByName(sc.nextLine());
		//判断
		if(telephone == null)
			//不等于null 打印电话本
			System.out.println("此人不存在");
		else
			System.out.println(telephone);
		
	}

	private static Telephone createTel(int oldIndex) {

		System.out.println("姓名：");
		String name = sc.nextLine();
		//获得当前姓名的索引
		int index = telService.selectIndexByName(name);
		//添加时若index为-1则添加，添加时传入的参数必须大于0
		//修改时若index不等于待修改的index则可以获得，即可修改
		if (index == -1 || index == oldIndex){
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

			return telephone;
		}
		return null;
	}
}
