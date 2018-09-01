package com.hpe.dao.gene;

import java.sql.SQLException;

/**
 * @Description:实现添加和修改操作的接口
 * @author chaoling
 * @param <T>
 * @date 2018年8月4日
 */
public interface IAddAndUpdate<T> {

	/**
	 * @Description: 根据传入信息进行添加
	 * @param e
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	int add(T t) throws SQLException;

	/**
	 * @Description: 根据传入信息进行修改
	 * @param e
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	int update(T t) throws SQLException;
}
