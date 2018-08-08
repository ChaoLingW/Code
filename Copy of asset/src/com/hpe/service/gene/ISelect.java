package com.hpe.service.gene;

/**
 * @Description:实现查询所有的接口
 * @author chaoling
 * @param <T>
 * @date 2018年8月4日
 */
public interface ISelect<T> {

	/**
	 * @Description: 查询所有的记录
	 * @return 对应的所有的记录
	 */
	T selectAll();
	
	
	
}
