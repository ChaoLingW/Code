package com.hpe.service.gene;

/**
 * @Description:实现修改功能的泛型接口
 * @author chaoling
 * @date 2018年8月5日
 * @param <T>
 */
public interface IUpdate<T> {

	/**
	 * @Description: 修改记录
	 * @param e 待修改的信息
	 * @return 受影响的行数
	 */
	int update (T t);
}
