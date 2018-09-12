/**
 * 
 */
package com.hpe.tf.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * sys_user_role表对应的实体类
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
@Table(name="sys_user_role")
public class SysUserRole {

	@Id
	@GeneratedValue
	private Integer id;		// 自增主键
	@Column(name="user_id")
	private Integer userId;	// 用户id
	@Column(name="role_id")
	private Integer roleId;	// 角色id
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
