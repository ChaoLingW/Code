package hpe.dao;

import java.util.List;

import hpe.po.User;

/**
 * 用户表操作的接口
 * @author chaoling
 *
 */
public interface IUserOption_jdbc {
	
	/**
	 *  查询所有记录，结果以对象列表形式返回
	 * @return 对象列表
	 * @throws Exception 
	 */
	List<User> queryAll() throws Exception;
	
}
