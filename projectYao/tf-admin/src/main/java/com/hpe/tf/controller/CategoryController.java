/**
 * 
 */
package com.hpe.tf.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpe.sys.util.R;
import com.hpe.tf.entity.Category;
import com.hpe.tf.service.CategoryService;

/**
 * 商品类别管理  控制类
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

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/**
	 *  查询商品分类（模糊查询）
	 *  
	 * @param category
	 * 			商品类别查询条件
	 * @param pageNum
	 * 			当前页码
	 * @param pageSize
	 * 			每页显示的数据大小
	 * @return 
	 * 			封装完成查询信息
	 */
	@RequestMapping(
			value="list", 	// 映射路径
			method=RequestMethod.POST, 	// 请求方式
			produces="application/json;charset=utf-8")	// 指定返回数据类型与编码格式
	@ResponseBody
	public R selectCatagoryList(Category category, int pageNum, int pageSize) {
		
		Map<String, Object> map = categoryService.selectCategoryList(category, pageNum, pageSize);
		// 把map封装到R类（简单封装，目的就是为了方便异步框架内处理已成，同时规范化）
		if (((List)map.get("rows")).isEmpty()) {
			// 未查到数据
			return R.error(-1, "没有数据");
		}
		return R.ok(map).put("page", map);
	}
	
	/**
	 *  添加商品分类
	 *  
	 * @param category
	 * 			待添加商品类别信息	
	 * @param pageNum
	 * 			当前页码
	 * @param pageSize
	 * 			每页显示的数据大小
	 * @return 
	 * 			封装完成查询信息
	 */
	@RequestMapping(
			value="addCategory", 	// 映射路径
			method=RequestMethod.POST, 	// 请求方式
			produces="application/json;charset=utf-8")	// 指定返回数据类型与编码格式
	@ResponseBody
	public R addCategory(Category category, int pageNum, int pageSize) {
		
		return null;
	}
	
	/**
	 *  修改商品分类
	 *  
	 * @param category
	 * 			待修改商品类别信息	
	 * @param pageNum
	 * 			当前页码
	 * @param pageSize
	 * 			每页显示的数据大小
	 * @return 
	 * 			封装完成查询信息
	 */
	@RequestMapping(
			value="updateCategory", 	// 映射路径
			method=RequestMethod.POST, 	// 请求方式
			produces="application/json;charset=utf-8")	// 指定返回数据类型与编码格式
	@ResponseBody
	public R updateCategory(Category category, int pageNum, int pageSize) {
		
		return null;
	}
	
	/**
	 *  删除商品分类
	 *  
	 * @param category
	 * 			待修改商品类别信息	
	 * @param pageNum
	 * 			当前页码
	 * @param pageSize
	 * 			每页显示的数据大小
	 * @return 
	 * 			封装完成查询信息
	 */
	@RequestMapping(
			value="deleteCategory", 	// 映射路径
			method=RequestMethod.POST, 	// 请求方式
			produces="application/json;charset=utf-8")	// 指定返回数据类型与编码格式
	@ResponseBody
	public R deleteCategory(List<Category> list, int pageNum, int pageSize) {
		
		return null;
	}
	
}
