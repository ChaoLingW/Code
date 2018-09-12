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
 * orders表对应的实体类
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
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;	// 订单id 自增主键
	@Column(name="order_sn")
	private String orderSn;		// 交易流水号
	@Column(name="member_id")
	private Integer memberId;	// 会员id
	@Column(name="member_name")
	private String memberName;	// 会员名称
	@Column(name="create_time")
	private String createTime;	// 创建时间
	private String payment;		// 金额
	@Column(name="pay_time")
	private String payTime;		// 支付时间
	private Integer state;		// 订单状态
	@Column(name="pay_type")
	private String payType;		// 支付方式
	@Column(name="order_detail")
	private String orderDetail;	// 订单收货信息
	private Integer disabled;	// 0- 未删除  1-删除
	
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
	 * @return the orderSn
	 */
	public String getOrderSn() {
		return orderSn;
	}
	/**
	 * @param orderSn the orderSn to set
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	/**
	 * @return the memberId
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	 * @return the payment
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	/**
	 * @return the payTime
	 */
	public String getPayTime() {
		return payTime;
	}
	/**
	 * @param payTime the payTime to set
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @return the orderDetail
	 */
	public String getOrderDetail() {
		return orderDetail;
	}
	/**
	 * @param orderDetail the orderDetail to set
	 */
	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
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
	
}
