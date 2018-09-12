/**
 * 
 */
package com.hpe.tf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpe.tf.dao.CategoryMapper;
import com.hpe.tf.entity.Category;
import com.hpe.tf.service.CategoryService;

/**
 * 商品类业务实现类
 * 
 * @author chaoling
 * @data  2018年9月11日
 * @version v1.0
 */
// 装配到spring容器中，使用注解方式
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public Map<String, Object> selectCategoryList(Category category, int pageNum, int pageSize) {
		
		// 设置分页查询
		PageHelper.startPage(pageNum, pageSize);
		// 模糊查询实现
		Example example = new Example(Category.class);
		Criteria c = example.createCriteria();
		
		// pId
		if (category != null && category.getpId() != null && !category.getpId().equals("")) {
			c.andEqualTo("pId", category.getpId());
		}
		// categoryName
		if (category != null && category.getCategoryName() != null && !category.getCategoryName().equals("")) {
			c.andLike("categoryName", "%" + category.getCategoryName() + "%");
		}
		// categoryPath
		if (category != null && category.getCategoryPath() != null && !category.getCategoryPath().equals("")) {
			c.andLike("categoryPath", "%" + category.getCategoryPath() + "%");
		}
		// level
		if (category != null && category.getLevel() != null && !category.getLevel().equals("")) {
			c.andEqualTo("level", category.getLevel());
		}
		// createTime
		if (category != null && category.getCreateTime() != null && !category.getCreateTime().equals("")) {
			c.andLike("createTime", "%" + category.getCreateTime() + "%");
		}
		// order by
		example.setOrderByClause(" pId desc ");
		
		// 调用方法查询
		List<Category> list = categoryMapper.selectByExample(example);
		// 返回分页信息,可选择return PageInfo。为了方便控制类获取数据，因此业务方法提供map类型
		PageInfo<Category> pageInfo = new PageInfo<Category>(list);
		Map<String, Object> map = new HashMap<String, Object>();
		// 当前页
		map.put("page", pageInfo.getPageNum());
		// 页码 页数
		map.put("pages", pageInfo.getPages());
		// 总数
		map.put("records", pageInfo.getTotal());
		// 数据
		map.put("rows", pageInfo.getList());

		return map;
	}

}
