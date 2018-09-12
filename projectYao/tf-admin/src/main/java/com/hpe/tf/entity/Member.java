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
 * member表对应的实体类
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
@Table(name="member")
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer memberId;	// 会员id 自增主键
	@Column(name="member_name")
	private String memberName;	// 会员名称
	private String account;		// 账号
	private String password;    // 密码
	private String phone;       // 电话
	private String address;     // 地址
	private Integer disabled;   // 是否删除 0未删除 1 删除
	
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
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
