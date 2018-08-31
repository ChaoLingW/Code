package hpe.view;

import java.util.Scanner;

import hpe.service.IUserService;
import hpe.service.UserServiceImpl;

/**
 * 操作视图，提供交互UI
 * 		仅供练习用，各功能模块之间的依赖关系（比如登录后才能删除等）弱化，可暂不考虑
 * @author jntcf
 *
 */
public class UserView {
	private static Scanner scanner = null;
	
	public static void main(String[] args) throws InterruptedException {

		//TODO：接收用户选择的输入项
		scanner = new Scanner(System.in);

		IUserService userService = new UserServiceImpl();
		
		while (true) {
			Thread.currentThread().sleep(100);//等待0.1s
			
			//打印主页面信息
			System.out.println("1. 用户登录");
			System.out.println("2. 用户注册");
			System.out.println("3. 用户删除");
			System.out.println("4. 用户修改");
			System.out.println("0. 退出");
			
			System.out.println("请输入操作号：");
			int iOption = scanner.nextInt();
			
			//判断输入，如果合法调用相应Service
			switch (iOption) {
			case 1://用户登录
				//System.out.println("TODO：用户登录");
				userService.userLogin();
				break;
			case 2://用户注册
				System.out.println("TODO：用户注册");
				break;
			case 3://用户删除
				System.out.println("TODO：用户删除");
				break;	
			case 4://用户修改
				System.out.println("TODO：用户修改");
				break;		
			case 0://退出
				System.out.println("== 收到退出指令，退出系统");
				return;	
			default:
				System.err.println("** 未知的操作符号："+ iOption);
				break;
			}
		}
		
	}

}
