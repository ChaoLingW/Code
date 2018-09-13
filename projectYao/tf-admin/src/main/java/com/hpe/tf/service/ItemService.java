/**
 * 
 */
package com.hpe.tf.service;

import java.util.Map;

import com.hpe.tf.entity.Item;

/**
 * 商品信息业务接口
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
public interface ItemService {
	
	/**
	 * 查询商品列表 
	 * 		分页查询 
	 * 		模糊查询（把查询信息封装成dto类）.借助实体类
	 * @param item 		模糊查询条件
	 * @param pageNum	当前页数
	 * @param pageSize	每页显示的记录数
	 * @return	map对象
	 * 				page 	当前页
	 * 				pages 	总页数
	 * 				records 总记录数
	 * 				rows  	数据
	 */
	Map<String, Object> selectItemList(Item item, int pageNum, int pageSize	);

}
