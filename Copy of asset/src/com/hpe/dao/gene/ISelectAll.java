package com.hpe.dao.gene;

import java.sql.SQLException;
import java.util.List;

import com.hpe.po.Bank;

/**
 * @Description:查询表中所有的接口
 * @author chaoling
 * @date 2018年8月4日
 */
public interface ISelectAll<T> {

	/**
	 * @Description: 查询所有
	 * @return 查询到的所有的记录，为null表示不能存在
	 * @throws SQLException 
	 */
	<T> T selectAll() throws SQLException;
}
