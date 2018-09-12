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
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(
			value="list", 	// 映射路径
			method=RequestMethod.POST, 	// 请求方式
			produces="application/json;charset=utf-8")	// 指定返回数据类型与编码格式
	@ResponseBody
	public R catagoryList(Category category, int pageNum, int pageSize) {
		
		Map<String, Object> map = categoryService.selectCategoryList(category, pageNum, pageSize);
		// 把map封装到R类（简单封装，目的就是为了方便异步框架内处理已成，同时规范化）
		if (((List)map.get("rows")).isEmpty()) {
			// 模拟
			return R.error(-1, "没有数据");
		}
		return R.ok(map).put("page", map);
	}
}
