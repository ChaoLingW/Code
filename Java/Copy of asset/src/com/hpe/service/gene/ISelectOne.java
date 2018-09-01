package com.hpe.service.gene;

/**
 * @Description:实现登录功能的接口
 * @author chaoling
 * @param <T>
 * @date 2018年8月4日
 */
public interface ISelectOne<T> {

	/**
	 * @Description: 登录功能
	 * @param t 待查询的用户的信息
	 * @return -1 此用户不存在 0 密码错误 1 登录成功
	 */
	 T login(T t);

}
