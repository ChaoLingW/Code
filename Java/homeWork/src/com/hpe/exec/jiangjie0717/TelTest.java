package com.hpe.exec.jiangjie0717;

import java.util.Scanner;

public class TelTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TelManage telManage = new TelManage();
		
		while(true){
			
			System.out.println("----------------电话本管理系统----------------");
			System.out.println("1.添加\t2.删除\t3.修改\t4.查询所有\t5.根据姓名查询\t0.退出");
			System.out.println("----------------电话本管理系统----------------");
			System.out.print("请选择业务：");
			
			int choice = sc.nextInt();
			
			//判断输入
			switch(choice){
			
			case 1:
				//添加
				telManage.addTel();
				break;
				
			case 2:
				//删除
				telManage.delTel();
				break;
				
			case 3:
				//修改
				telManage.updateTel();
				break;
				
			case 4:
				//查询全部
				telManage.selectAllTel();
				break;
				
			case 5:
				//根据姓名查询
				telManage.selectTelByName();
				break;
				
			case 0:
				//退出
				System.out.println("谢谢使用");
				System.exit(0);
				break;
			
			default:
				System.out.println("输入有误，请重新输入");
				break;
			
			}
			
		}
	}
	
	
	
	
	
	

}
