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
 * order_item表对应的实体类
 * 
 * @author houhuaishan
 * @data  2018年9月12日
 * @version v1.0
 */
/**
 *  添加@Table注解
 *  
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.1
 */
@Table(name="order_item")
public final class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderItemId;	// 订单商品id 自增主键
	@Column(name="order_id")
	private Integer orderId;	    // 订单id
	@Column(name="item_id")
	private Integer itemId;			// 商品id
	@Column(name="item_title")
	private String itemTitle;		// 商品名称
	private String price;			// 商品价格
	private Integer number;			// 购买数量
	
	/**
	 * @return the orderItemId
	 */
	public Integer getOrderItemId() {
		return orderItemId;
	}
	/**
	 * @param orderItemId the orderItemId to set
	 */
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
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
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
