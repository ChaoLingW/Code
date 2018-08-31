package hpe.dao;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hpe.po.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public User queryUserByNameAndPwd(User u) {
		// 创建工厂
		SqlSessionFactory sessionFactory = null;
		try {
			sessionFactory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 获取连接
		SqlSession session = sessionFactory.openSession();
		
		// 调用statment id，执行查询
		User user = session.selectOne("test.queryUserByNameAndPwd",u);
		
		// 释放资源
		session.close();
		
		
		return user;
	}

}
