package hpe.dao;

import java.util.List;

import hpe.po.User;

public class UserOptionImpl_mybatis implements IUserOption_jdbc {

	// 配置SqlMapConfig.xml mapper.xml
	// 导入jar包

	@Override
	public List<User> queryAll() throws Exception {

		// TODO: 创建工厂

		// 获取一个sql连接：SqlSession

		// 执行

		// 释放资源
		return null;
	}

}
