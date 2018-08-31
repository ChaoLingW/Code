package hpe.view;

import java.util.Scanner;

import hpe.po.User;
import hpe.service.IUserService;
import hpe.service.impl.UserServiceImpl;

/**
 * @author chaoling
 * 2018年8月28日
 */

public class UserView {

	private static IUserService userService = new UserServiceImpl(); // userService对象
	private static Scanner sc = new Scanner(System.in); // 获取输入

	public static void main(String[] args) {

		boolean flag = true; // 标志 控制while循环

		while (flag) {
			// 显示界面
			menu();
			// 接收选择
			System.out.println("请输入操作号：");
			int iOption = sc.nextInt();
			sc.nextLine();
			// 判断输入，如果合法调用相应Service
			switch (iOption) {
			case 1:
				// 用户登录
				if (userLogin() != null) {
					//登录成功
					//调用userSelect
					userSelect();
				}
				break;
			case 2:
				// 用户注册
				userRegister();
				break;
			case 3:
				// 用户删除
				userDelete();
				break;
			case 4:
				// 用户修改
				userUpdate();
				break;
			case 0:
				// 退出
				System.out.println("== 收到退出指令，退出系统");
				return;
			default:
				System.err.println("** 未知的操作符号：" + iOption);
				break;
			}
		}
	}

	/**
	 *  用户登录显示
	 */
	private static User userLogin() {

		// 获取用户信息
		System.out.println("请输入用户名");
		String username = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();

		// 将登录信息封装到对象中
		User user = new User(username, password);

		// 调用userLogin方法
		User userLogin = userService.userLogin(user);
		// 判断是否登录成功
		if (userLogin != null) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}
		// 返回返回值
		return userLogin;
	}

	/**
	 *  用户注册显示
	 */
	private static void userRegister() {

		// 接收注册信息 并调用insertUser方法
		int res = userService.insertUser(info());
		// 判断
		if (res == -1) {
			// 用户名已存在
			System.out.println("用户名已存在");
		} else if (res == 0) {
			// 注册失败
			System.out.println("注册失败");
		} else {
			// 注册成功 并输出id
			System.out.println("注册成功，ID为：" + res);
		}
	}

	/**
	 *  用户删除显示
	 */
	private static void userDelete() {

		System.out.println("请输入要删除的用户名");
		// 获取要删除的用户名
		String username = sc.next();
		// 调用deleteUserByUsername方法
		int res = userService.deleteUserByUsername(username);
		// 判断
		if (res == -1) {
			// 用户名不存在
			System.out.println("用户名不存在");
		} else if (res == 0) {
			// 删除失败
			System.out.println("删除失败");
		} else {
			// 删除成功
			System.out.println("删除成功");
		}
	}

	/**
	 *  用户修改显示
	 */
	private static void userUpdate() {

		System.out.println("请输入要修改用户的id");
		// 获取要修改用户的id
		int id = Integer.parseInt(sc.nextLine());
		// 判断此id是否存在
		User selectUser = userService.selectUserById(id);
		// 不存在结束方法
		if (selectUser == null) {
			System.out.println("此用户不存在");
			return;
		}
		
		// 获取用户的修改信息
		User updateUser = info();
		updateUser.setId(id);
		// 调用updateUserById方法
		int res = userService.updateUserById(updateUser);

		if (res == -1 ) {
			System.out.println("此用户名已存在");
		} else if (res == 0) {
			// 修改失败
			System.out.println("修改失败");
		} else {
			// 修改成功
			System.out.println("修改成功");
		}
	}

	/**
	 *  接收用户信息
	 * @return 用户对象
	 */
	private static User info() {

		// 获取信息
		System.out.println("请输入用户名");
		String username = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();
		System.out.println("请输入真实姓名");
		String realName = sc.nextLine();
		System.out.println("请输入性别");
		String gender = sc.nextLine();

		// 封装到对象 并返回
		return new User(username, password, realName, gender);
	}

	/**
	 * 显示主界面
	 */
	private static void menu() {

		System.out.println("1. 用户登录");
		System.out.println("2. 用户注册");
		System.out.println("3. 用户删除");
		System.out.println("4. 用户修改");
		System.out.println("0. 退出");
	}

	/**
	 *  用户查询界面
	 */
	private static void userSelect(){
		
		boolean flag = true;	// 标志 while循环
		
		while (flag) {
			System.out.println("1.根据id查询\t 2.根据用户名查询\t 0.退出");
			System.out.println("请输入你的选择");
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1":
				// 根据id查询用户
				selectUserById();
				break;

			case "2":
				// 根据username查询用户
				selectUserByUsername();
				break;

			case "0":
				// 退出
				flag = false;
				break;
			default:
				// 选择错误
				System.out.println("选择错误，请重新选择");
				break;
			}
		}
	}
	
	/**
	 * 根据用户id查询显示
	 */
	private static void selectUserById() {

		System.out.println("请输入要查询的用户的id");
		// 获取待查询用户的id
		int id = sc.nextInt();
		sc.nextLine();
		// 调用userService.queryUserById()，接收返回值
		User user = userService.selectUserById(id);

		// 判断
		if (user == null) {
			// 用户不存在
			System.out.println("用户不存在");
		} else {
			// 用户存在
			System.out.println(user);
		}
	}

	/**
	 *  根据用户名查询显示
	 */
	private static void selectUserByUsername() {

		System.out.println("请输入要查询用户的用户名");
		// 获取待查询用户的username
		String username = sc.nextLine();
		// 调用userService.queryUserByUsername()，接收返回值
		User user = userService.selectUserByUsername(username);

		// 判断
		if (user == null) {
			// 用户不存在
			System.out.println("用户不存在");
		} else {
			// 用户存在
			System.out.println(user);
		}
	}

}
