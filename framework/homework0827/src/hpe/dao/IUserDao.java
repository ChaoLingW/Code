package hpe.dao;

import java.util.List;

import hpe.po.User;

/**
 * user表操作的接口
 * 
 * @author chaoling 2018年8月27日
 */
public interface IUserDao {

	/**
	 * 根据用户ID进行查询
	 * 
	 * @param id
	 *            待查询用户的id
	 * @return 查询成功 用户对象（全部属性） 查询失败 null
	 * @throws Exception
	 */
	User selectUserById(int id) throws Exception;

	/**
	 * 根据用户名进行查询
	 * 
	 * @param username
	 *            待查询用户的username
	 * @return 查询成功 用户对象（全部属性） 查询失败 null
	 * @throws Exception
	 */
	User selectUserByUsername(String username) throws Exception;

	/**
	 * 查询所有的用户
	 * 
	 * @return 查询成功 user表中所有的记录 查询失败 null
	 * @throws Exception
	 */
	List<User> selectUserAll() throws Exception;

	/**
	 * 查询密码带”1”的女生并显示
	 * 
	 * @return 查询成功 user表中所有符合的所有记录对应的列表 查询失败 null
	 * @throws Exception
	 */
	List<User> selectUserByPasswordAndGender() throws Exception;

	/**
	 * 根据用户名密码查询
	 * 
	 * @param user
	 *            必须设置username和password
	 * @return 查询成功 用户对象（全部属性） 查询失败 null
	 * @throws Exception
	 */
	User selectUserByUsernameAndPassword(User user) throws Exception;

	/**
	 * 添加记录
	 * 
	 * @param user
	 *            待添加的信息（不包括id）
	 * @return  0 添加失败 > 0添加成功
	 * @throws Exception
	 */
	int insertUser(User user) throws Exception;

	/**
	 * 根据用户名删除用户
	 * 
	 * @param username
	 *            待删除用户的用户名
	 * @return 受影响的行数 0 添加失败 1 添加成功
	 * @throws Exception
	 */
	int deleteUserByUsername(String username) throws Exception;

	/**
	 * 根据用户id修改记录
	 * 
	 * @param user
	 *            待修改用户的信息
	 * @return 受影响的行数 0 添加失败 1 添加成功
	 * @throws Exception
	 */
	int updateUserById(User user) throws Exception;

}
