package hpe.dao;

import java.util.List;

import hpe.po.User;

/**
 * �û�������Ľӿ�
 * @author chaoling
 *
 */
public interface IUserOption_jdbc {
	
	/**
	 *  ��ѯ���м�¼������Զ����б���ʽ����
	 * @return �����б�
	 * @throws Exception 
	 */
	List<User> queryAll() throws Exception;
	
}
