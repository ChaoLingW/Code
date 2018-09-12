/**
 * 
 */
package com.hpe.tf.service;

import java.util.Map;

import com.hpe.tf.entity.Category;

/**
 * 商品类别业务接口
 * 
 * @author chaoling
 * @data 2018年9月11日
 * @version v1.0
 */
public interface CategoryService {

	/**
	 * 查询商品列表 
	 * 		分页查询 
	 * 		模糊查询（把查询信息封装成dto类）.借助实体类
	 * @param category 	模糊查询条件
	 * @param pageNum	当前页数
	 * @param pageSize	每页显示的记录数
	 * @return
	 */
	Map<String, Object> selectCategoryList(Category category, int pageNum, int pageSize	);

}
