package com.hpe.dao.gene;

import java.sql.SQLException;

/**
 * @Description:对表中某条记录的进行查询
 * @author chaoling
 * @date 2018年8月4日
 */
public interface ISelectOne<T> {

	/**
	 * @Description: 根据传入的参数查询记录
	 * @param t 待查询记录的信息
	 * @return 对应的记录
	 * @throws SQLException 
	 */
	T selectOne(T t) throws SQLException;

}
