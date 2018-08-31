package hpe.service;

import java.util.Scanner;

import hpe.dao.IUserDao;
import hpe.dao.UserDaoImpl;
import hpe.po.User;

public class UserServiceImpl implements IUserService {

	@Override
	public void userLogin() {
		//	输入：用户名、密码
		Scanner scann = new Scanner(System.in);
		
		System.out.println("请依次输入用户名和密码：");
		User u = new User();
		u.setUsername(scann.next());
		u.setPwd(scann.next());
		
		//验证
		IUserDao userDao = new UserDaoImpl();
		
		User user = userDao.queryUserByNameAndPwd(u);
		
		
		// 输出：登录结果
		if (user == null) {
			System.err.println("登录失败");
		}
		else {
			System.out.println("登录成功："+user);
		}
	}

}
