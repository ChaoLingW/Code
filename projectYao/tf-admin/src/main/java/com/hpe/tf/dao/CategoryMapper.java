/**
 * 
 */
package com.hpe.tf.dao;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.hpe.tf.entity.Category;

/**
 * 商品类别CategoryMapper接口类
 * 
 * @author chaoling
 * @data  2018年9月11日
 * @version v1.0
 */
/**
 * add 修改功能方法声明
 * add 删除功能方法声明
 * 
 * @author chaoling
 * @data  2018年9月13日
 * @version v1.1
 */
public interface CategoryMapper extends Mapper<Category> {
	
	/**
	 * 修改商品类别
	 * 
	 * @param category	待修改商品类别信息
	 * 			categoryId		商品类别id
	 * 			pId				父级id
	 * 			categoryName	商品类别名称
	 * 			level			级别	
	 * @return			受影响的行数
	 * 			>0  	修改成功
	 * 			<=0   	修改失败
	 */
	int updateCategoryById(Category category);
	
	/**
	 * 删除商品类别
	 * 
	 * @param category	待删除商品类别的id组成的集合
	 * @return			受影响的行数
	 * 			>0  	添加成功
	 * 			<=0   	添加失败
	 */
	int deleteCategoryById(List<Category> category);
	
}
