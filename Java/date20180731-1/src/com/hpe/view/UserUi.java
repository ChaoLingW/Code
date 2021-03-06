package com.hpe.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hpe.po.User;
import com.hpe.service.IUserService;
import com.hpe.service.impl.UserServiceImpl;


public class UserUi {

	static Scanner sc = new Scanner(System.in);
	static IUserService userService = new UserServiceImpl();
	
	public static void main(String[] args) {

		while (true) {

			System.out.println("-----------用户管理----------");
			System.out.println("1.添加\t2.删除\t3.修改\t4查询\t5.查询全部\t0.退出");
			System.out.println("请选择业务：");

			String choice = sc.nextLine();

			switch (choice) {
			case "1":
				add();
				break;

			case "2":
				delete();
				break;

			case "3":
				update();
				break;

			case "4":
				select();
				break;

			case "5":
				selectAll();
				break;

			case "0":
				System.out.println("谢谢使用");
				System.exit(0);
				break;

			default:
				System.out.println("输入有误");
				break;
			}
		}
	}
	
	
	private static void add() {
		// 显示工作
		System.out.println("请输入用户名");
		String userName = sc.nextLine();

		System.out.println("请输入密   码");
		String password = sc.nextLine();

		System.out.println("请输入真实姓名");
		String realName = sc.nextLine();

		System.out.println("请输入年   龄");
		int age = sc.nextInt();
		sc.nextLine();

		User user = new User(0, userName, password, realName, age);
		int res = userService.addUser(user);
		if(res > 0)
			System.out.println("添加成功");
		else if(res == 0)
			System.out.println("添加失败");
		else
			System.out.println("用户名 已存在无法添加");
	}

	
	//删除显示
	private static void delete() {

		System.out.println("请输入删除人的名字");
		String name = sc.nextLine();
		
		int res = userService.deleteUserByName(name);
		
		if(res > 0)
			System.out.println("删除成功");
		else if(res == 0)
			System.out.println("删除失败");
		else
			System.out.println("用户名不存在，无法删除");
	}

	private static void update() {
		System.out.println("请输入修改人的姓名");
		String username = sc.nextLine();
		//调用selectByName(String),如果User不为null才修改，为null打印不存在
		User user = userService.seleteByName(username);
		
		if(user == null){
			System.out.println("此人不存在");
			return;
		}
		System.out.println(user);
		System.out.println("请输入新的密码");
		String password = sc.nextLine();
		
		System.out.println("请输入新的真实姓名");
		String realName = sc.nextLine();
		
		System.out.println("请输入新的年龄");
		String strAge = sc.nextLine();
		int age = Integer.parseInt(strAge);
		
		User newUser = new User(0, username, password, realName, age);
		
		int res = userService.updateByName(newUser);
		
		if(res > 0)
			System.out.println("修改成功");
		else
			System.out.println("修改失败");
	}

	private static void selectAll() {
	
		List<User> users = userService.seleteAllUser();
		
		if(users != null && users.size() > 0)
			for(User user : users)
				System.out.println(user);
	}

	private static void select() {
		System.out.println("请输入查询人的姓名");
		String username = sc.nextLine();
		//调用selectByName(String),如果User不为null才打印，为null打印不存在
		User user = userService.seleteByName(username);
		
		if(user == null){
			System.out.println("此人不存在");
			return;
		}
		System.out.println(user);
	}

}
