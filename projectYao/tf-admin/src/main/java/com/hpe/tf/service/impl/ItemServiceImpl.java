/**
 * 
 */
package com.hpe.tf.service.impl;

import java.util.ArrayList;
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
import com.hpe.tf.dao.ItemMapper;
import com.hpe.tf.dto.ItemInfo;
import com.hpe.tf.entity.Category;
import com.hpe.tf.entity.Item;
import com.hpe.tf.service.ItemService;

/**
 * 商品信息业务实现类
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private CategoryMapper cateMapper;
	
	@Override
	public Map<String, Object> selectItemList(Item item, int pageNum, int pageSize) {
		
		// 设置分页查询
		PageHelper.startPage(pageNum, pageSize);
		// 设置模糊查询
		Example example = new Example(Item.class);
		Criteria criteria = example.createCriteria();
		
		// itemTitle
		if (item != null && item.getItemTitle() != null && item.getItemTitle().equals("")) {
			criteria.andLike("itemTitle", "%" + item.getItemTitle() + "%");
		}
		// item_img
		if (item != null && item.getItemImg() != null && item.getItemImg().equals("")) {
			criteria.andLike("itemImg", "%" + item.getItemImg() + "%");
		}
		// itemDesc
		if (item != null && item.getItemDesc() != null && item.getItemDesc().equals("")) {
					criteria.andLike("itemDesc", "%" + item.getItemDesc() + "%");
		}
		// price
		if (item != null && item.getPrice() != null && item.getPrice().equals("")) {
			criteria.andEqualTo("price", item.getPrice());
		}
		// sales;
		if (item != null && item.getSales() != null && item.getSales().equals("")) {
			criteria.andEqualTo("sales", item.getSales());
		}
		// createTime
		if (item != null && item.getCreateTime() != null && item.getCreateTime().equals("")) {
			criteria.andLike("createTime", "%" + item.getCreateTime() + "%");
		}
		// isRecommend
		if (item != null && item.getIsRecommend() != null && item.getIsRecommend().equals("")) {
			criteria.andEqualTo("isRecommend", item.getIsRecommend());
		}
		// order by
		example.setOrderByClause(" itemId desc ");
		
		// 数据表中的商品信息
		List<Item> itemList = itemMapper.selectByExample(example);
		// 查询商品分类信息
		List<Category> categoryList = cateMapper.select(null);
		//  前端界面需要的商品信息
		List<ItemInfo> list = new ArrayList();
		// 分类的处理 
		Map<Integer, String> categoryName = new HashMap<Integer, String>();
		
		// 不为null 且size大于0
		if(categoryList != null && categoryList.size() > 0) {
			// 分类id与分类名映射为map kay=categoryId value=categoryName
			for(Category category : categoryList) {
				categoryName.put(category.getCategoryId(), category.getCategoryName());
			}
		}
		
		// 不为null 且size大于0
		if(itemList != null && itemList.size() > 0) {
			// 封装前端所需商品信息
			for (int i = 0; i < itemList.size(); i++) {
				// 获取商品信息
				Item itemJoin = itemList.get(i);	
				// 前端所需商品信息
				ItemInfo itemInfo = new ItemInfo();
				
				// 判断分类关系是否存在及是否存在数据  防止空指针异常与无数据的情况
				if (categoryName != null && categoryName.size() > 0) {
					itemInfo.setCategoryName(categoryName.get(itemJoin.getCategoryId()));	// 设置分类名称
				}
				
				// 返回商品信息封装
				itemInfo.setItemTitle(itemJoin.getItemTitle());		// 设置商品名称
				itemInfo.setItemImg(itemJoin.getItemImg());    		// 设置商品图片
				itemInfo.setItemDesc(itemJoin.getItemDesc());		// 设置商品描述
				itemInfo.setPrice(itemJoin.getPrice());				// 设置商品价格
				itemInfo.setSales(itemJoin.getSales());				// 设置商品销量
				itemInfo.setCreateTime(itemJoin.getCreateTime());	// 设置商品创建时间
				itemInfo.setIsRecommend(itemJoin.getIsRecommend());	// 设置商品是否推荐
				
				// 添加到list
				list.add(itemInfo);
				
			}
		}
		
		// 封装分页信息
		PageInfo<ItemInfo> pageInfo = new PageInfo<ItemInfo>(list);
		// 返回信息封装
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
