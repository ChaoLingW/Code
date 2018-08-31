package hpe.dao;

import hpe.po.User;

public interface IUserDao {
	/**
	 * 按用户名和密码进行用户查询
	 * 
	 * @param u 用户对象（设置了username、pwd属性）
	 * @return
	 * 		用户对象（含所有属性）	查询ok
	 * 		null			没有查询到
	 */
	User queryUserByNameAndPwd (User u);
	
}
