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
 * sys_menu表对应的实体类
 * 
 * @author chaoling
 * @data  2018年9月12日
 * @version v1.0
 */
@Table(name="sys_menu")
public class SysMenu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuId;		// 会员id 自增主键
	@Column(name="parent_id")	//
	private Integer parenId;	// 
	private String name;		// 姓名
	private String url;			// 路径
	private String perms;		// 
	private Integer type;		//	
	private String icon;		//
	@Column(name="order_num")	//
	private Integer orderNum;	//
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
	/**
	 * @return the parenId
	 */
	public Integer getParenId() {
		return parenId;
	}
	/**
	 * @param parenId the parenId to set
	 */
	public void setParenId(Integer parenId) {
		this.parenId = parenId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the perms
	 */
	public String getPerms() {
		return perms;
	}
	/**
	 * @param perms the perms to set
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the orderNum
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
}
