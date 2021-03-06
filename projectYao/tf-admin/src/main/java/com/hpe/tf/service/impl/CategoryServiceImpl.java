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
 * 商品类别业务实现类
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
		Criteria criteria = example.createCriteria();
		
		// pId
		if (category != null && category.getpId() != null && !category.getpId().equals("")) {
			criteria.andEqualTo("pId", category.getpId());
		}
		// categoryName
		if (category != null && category.getCategoryName() != null && !category.getCategoryName().equals("")) {
			criteria.andLike("categoryName", "%" + category.getCategoryName() + "%");
		}
		// order by
		example.setOrderByClause(" categoryId asc ");
		
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

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(List<Integer> category) {
		// TODO Auto-generated method stub
		return false;
	}

}
