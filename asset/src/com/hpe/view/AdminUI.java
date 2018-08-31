package com.hpe.view;

import java.util.List;
import java.util.Scanner;

import com.hpe.po.Admin;
import com.hpe.po.Bank;
import com.hpe.po.User;
import com.hpe.service.IAdminService;
import com.hpe.service.IBankService;
import com.hpe.service.IUserService;
import com.hpe.service.impl.AdminServiceImpl;
import com.hpe.service.impl.BankServiceImpl;
import com.hpe.service.impl.UserServiceImpl;


/**
 * @Description:管理员显示
 * @author chaoling
 * @date 2018年7月30日
 */
public class AdminUI {

	private IAdminService adminService = new AdminServiceImpl();
	private IBankService bankService = new BankServiceImpl();
	private IUserService userService = new UserServiceImpl();
	private Scanner sc = new Scanner(System.in);
	private Admin admin = new Admin();
	private Bank bank = new Bank();

	/**
	 * @Description: 管理员登录界面的入口
	 */
	public void admin() {

		System.out.println("------------个人资产管理系统------------");

		//登录操作
		login();
		
		//利用adminId判断是否登录成功，若不成功，结束函数
		if (admin.getAdminId() < 1)
			return;

		while (true) {
			//菜单显示
			menu();
			//接收输入
			String chioce = sc.nextLine();

			switch (chioce) {

			case "1":
				//查询所有的用户
				selectAllUser();
				break;
			case "2":
				//添加银行
				addBank();
				break;
			case "3":
				//修改银行
				updateBank();
				break;
			case "4":
				//删除银行
				deleteBank();
				break;
			case "5":
				//查询所有的银行
				selectAllBank();
				break;
			case "6":
				//返回主界面
				System.out.println("谢谢使用");
				return;
			default:
				//非法输入处理
				System.out.println("输入错误，请重新输入！");
				break;
			}
		}

	}

	/**
	 * @Description: 登录界面显示
	 */
	private void login() {

		System.out.println("************** 管理员登录 *************");
		System.out.println("请输入用户名");
		String adminName = sc.nextLine();
		System.out.println("请输入密   码");
		String adminPassword = sc.nextLine();
		//将接收的信息封装成对象
		admin = new Admin(0, adminName, adminPassword);
		//接收返回值
		admin= adminService.select(admin);
		//对不同的返回值做不同的输出处理
		if (admin== null)
			System.out.println("此用户不存在");
		else
			System.out.println("登录成功");
	}
	
	/**
	 * @Description: 菜单显示
	 */
	private void menu() {

		System.out.println("------------个人资产管理系统------------");
		System.out.println("******[欢迎您，管理员-" + admin.getAdminName() + "]*******");
		System.out.println("1.查看所有用户\t2.添加银行\t3.修改银行\t4.删除银行\t5.查看所有银行\t6.返回登录主菜单");
		System.out.println("------------个人资产管理系统------------");
		System.out.println("请选择业务");

	}

	/**
	 * @Description: 查看所有用户
	 */
	private void selectAllUser() {

		System.out.println("------------查看所有用户------------");
		//接收返回值
		List<User> users = userService.selectAllUser();
		//为null，结束函数
		if (users == null)
			return;
		//遍历输出
		for (User user : users)
			System.out.println(user);

	}

	/**
	 * @Description: 添加银行
	 */
	private void addBank() {

		System.out.println("------------添加银行------------");
		System.out.println("请输入银行名：");
		String bankName = sc.nextLine();
		System.out.println("请输入银行电话：");
		String bankTel = sc.nextLine();
		//将接收的银行封装为对象
		bank = new Bank(0, bankName, bankTel);
		//接收返回值
		int res = bankService.addBank(bank);
		//对不同的返回值做不同的输出显示
		if (res == -1)
			System.out.println("该银行已存在，请确认后添加");
		else if (res == 0)
			System.out.println("添加银行失败");
		else
			System.out.println("添加银行成功");

	}

	/**
	 * @Description: 修改银行
	 */
	private void updateBank() {

		System.out.println("------------修改银行------------");
		System.out.println("请输入要修改的银行编号");
		String strBankId = sc.nextLine();
		int bankId = Integer.parseInt(strBankId);
		//对要修改的银行编号判断是否存在
		if (bankService.selectBankByBankId(bankId)) {
			//存在
			System.out.println("请输入新的银行名");
			String bankName = sc.nextLine();
			System.out.println("请输入新的银行电话");
			String bankTel = sc.nextLine();
			//将要修改的银行信息封装为对象
			bank = new Bank(bankId, bankName, bankTel);
			//接收返回值
			int res = bankService.updateBank(bank);
			//根据返回值做不同的判断
			if (res == 1)
				System.out.println("修改银行信息成功");
			else if (res == 0)
				System.out.println("修改银行信息失败");
			else
				System.out.println("银行姓名已存在");
		} else
			//银行不存在
			System.out.println("银行不存在");

	}

	/**
	 * @Description: 删除银行
	 */
	private void deleteBank() {

		System.out.println("------------删除银行------------");
		System.out.println("请输入要删除的银行编号");
		String strBankId = sc.nextLine();
		int bankId = Integer.parseInt(strBankId);
		 
		//判断该bankId是否存在
		if (bankService.selectBankByBankId(bankId)) {
			//输出信息
			System.out.println(bank);
			System.out.println("确认删除吗？ y/n");
			String chice = sc.nextLine();
			if (chice.equals("y")) {
				//删除操作
				if (bankService.deleteBank(bankId) > 0)
					System.out.println("删除成功");
				else
					System.out.println("删除失败");
			} else if (chice.equals("n"))
				//取消删除
				System.out.println("你选择了取消");
			else
				//非法输入处理
				System.out.println("输入错误");
		} else
			//银行不存在
			System.out.println("银行不存在");
	}

	/**
	 * @Description: 查看所有的银行
	 */
	private void selectAllBank() {

		System.out.println("------------查看所有银行------------");
		//接收返回值
		List<Bank> banks = bankService.selectAllBank();
		//为null 结束函数
		if (banks == null){
			System.out.println("暂无记录");
			return;
		}
		//遍历输出
		for (Bank bank : banks)
			System.out.println(bank);
	}

}
