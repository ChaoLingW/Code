/**
 * 
 */
package com.hpe.tf.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * sys_role_menu表对应的实体类
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
@Table(name="sys_role_menu")
public class SysRoleMenu {

	@Id
	@GeneratedValue
	private Integer id;		// 自增主键
	@Column(name="role_id")
	private Integer roleId;	// 角色id
	@Column(name="menu_id")
	private Integer menuId;	// 会员id
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
	/**
	 * @return the menuId
	 */
	public Integer getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
}
