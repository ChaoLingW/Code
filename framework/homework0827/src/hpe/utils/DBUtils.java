package hpe.utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类
 * 
 * @author chaoling 2018年8月28日
 */
public class DBUtils {

	private static SqlSessionFactory sessionFactory; // 工厂对象

	static {
		try {
			// 初始化 工厂对象
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Sql连接
	 * 
	 * @return Sql连接
	 */
	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}

	/**
	 * 关闭Sql连接
	 * 
	 * @param session
	 *            待关闭的sql连接
	 */
	public static void closeSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}

}
