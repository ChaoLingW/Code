/**
 * 
 */
package com.hpe.tf.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * item表对应的实体类
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer itemId;		// 商品id 自增主键
	@Column(name="category_id")
	private Integer categoryId;	// 分类id
	@Column(name="item_title")
	private String itemTitle;	// 商品名称
	@Column(name="item_img")
	private String item_img;	// 商品图片
	@Column(name="item_desc")	
	private String itemDesc;	// 商品详细描述
	private String price;		// 商品价格
	private Integer sales;		// 销量
	@Column(name="create_time")
	private String createTime;	// 创建时间
	private Integer disabled;	// 0- 未删除  1-删除
	@Column(name="is_recommend")
	private Integer isRecommend;// 是否推荐商品 0- 不是 1-是
	
	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the itemTitle
	 */
	public String getItemTitle() {
		return itemTitle;
	}
	/**
	 * @param itemTitle the itemTitle to set
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	/**
	 * @return the item_img
	 */
	public String getItem_img() {
		return item_img;
	}
	/**
	 * @param item_img the item_img to set
	 */
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	/**
	 * @return the itemDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}
	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the sales
	 */
	public Integer getSales() {
		return sales;
	}
	/**
	 * @param sales the sales to set
	 */
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the disabled
	 */
	public Integer getDisabled() {
		return disabled;
	}
	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	/**
	 * @return the isRecommend
	 */
	public Integer getIsRecommend() {
		return isRecommend;
	}
	/**
	 * @param isRecommend the isRecommend to set
	 */
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	
}
