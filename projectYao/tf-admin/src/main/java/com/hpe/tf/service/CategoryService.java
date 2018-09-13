/**
 * 
 */
package com.hpe.tf.service;

import java.util.List;
import java.util.Map;

import com.hpe.tf.entity.Category;

/**
 * 商品类别业务接口
 * 
 * @author chaoling
 * @data 2018年9月11日
 * @version v1.0
 */
/**
 * add 修改功能方法声明
 * add 新增功能方法声明
 * add 删除功能方法声明
 * 
 * @author chaoling
 * @data  2018年9月13日
 * @version v1.1
 */
public interface CategoryService {

	/**
	 * 查询商品类别列表 
	 * 		分页查询 
	 * 		模糊查询（把查询信息封装成dto类）.借助实体类
	 * @param category 	模糊查询条件
	 * 				pId 	父级id
	 * 				category分类名称
	 * @param pageNum	当前页数
	 * @param pageSize	每页显示的记录数
	 * @return	map对象
	 * 				page 	当前页
	 * 				pages 	总页数
	 * 				records 总记录数
	 * 				rows  	数据
	 */
	Map<String, Object> selectCategoryList(Category category, int pageNum, int pageSize	);

	/**
	 * 添加商品类别
	 * 
	 * @param category	待添加商品类别信息
	 * 			pId				父级id
	 * 			categoryName	商品类别名称
	 * 			categoryPath	商品类别路径
	 * 			level			级别
	 * 			createTime		创建时间			
	 * @return
	 * 			false  添加成功
	 * 			true   添加失败
	 */
	boolean addCategory(Category category);
	
	/**
	 * 修改商品类别
	 * 
	 * @param category	待修改商品类别信息
	 * 			categoryId		商品类别id
	 * 			pId				父级id
	 * 			categoryName	商品类别名称
	 * 			level			级别
	 * @return
	 * 			false  修改成功
	 * 			true   修改失败
	 */
	boolean updateCategory(Category category);
	
	/**
	 * 删除商品类别
	 * 
	 * @param category	待删除商品类别的id组成的集合
	 * @return
	 * 			false  修改成功
	 * 			true   修改失败
	 */
	boolean deleteCategory(List<Integer> category);

}
