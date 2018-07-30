package com.hp.view;

import java.util.Scanner;

import com.hp.po.Admin;
/**
 * @Description:管理员显示
 * @author chaoling
 * @date 2018年7月30日
 */
public class AdminUI {

	/**
	 * @Description: 管理员登录的入口
	 */
	public void admin(){
		
		System.out.println("------------个人资产管理系统------------");
		System.out.println("************** 管理员登录 *************");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入用户名");
		String adminName = sc.nextLine();
		System.out.println("请输入密   码");
		String adminPassword = sc.nextLine();
		
		Admin admin = new Admin(0, adminName, adminPassword);
	}
}
