package com.hpe.service.gene;

/**
 * @Description:实现添加功能的接口
 * @author chaoling
 * @param <T>
 * @date 2018年8月4日
 */
public interface IAdd<T> {

	/**
	 * @Description: 添加
	 * @param e 待添加的记录
	 * @return 受影响的行数/对应记录的id
	 */
	int add(T t);
}
