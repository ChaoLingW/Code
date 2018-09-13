/**
 * 
 */
package com.hpe.tf.dto;

import javax.persistence.Column;

/**
 * 商品信息查询对应的类
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
public class ItemInfo {
	
	private String categoryName; 	// 分类名称
	private String itemTitle;		// 商品名称
	private String itemImg;			// 商品图片
	private String itemDesc;		// 商品详细描述
	private String price;			// 商品价格
	private Integer sales;			// 销量
	private String createTime;		// 创建时间
	private Integer isRecommend;	// 是否推荐商品 0- 不是 1-是
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	 * @return the itemImg
	 */
	public String getItemImg() {
		return itemImg;
	}
	/**
	 * @param itemImg the itemImg to set
	 */
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
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
