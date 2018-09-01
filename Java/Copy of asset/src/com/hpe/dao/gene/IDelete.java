package com.hpe.dao.gene;

import java.sql.SQLException;

/**
 * @Description:对表中的一条/多条信息进行删除
 * @author chaoling
 * @date 2018年8月4日
 */
public interface IDelete {

	/**
	 * @Description: 对表中的一条/多条信息进行删除 
	 * @param id 待删除的id
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	int delete (int id) throws SQLException;
}
