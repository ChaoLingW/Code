package com.hpe.tf.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品类别category表对应的实体类
 * 
 * @author chaoling
 * @data 2018年9月11日
 * @version v1.0
 */
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;		// 分类id 自增主键
	@Column(name = "p_id")
	private Integer pId;			// 父级id
	@Column(name = "category_name")	
	private String categoryName;	// 分类名称
	@Column(name = "category_path")
	private String categoryPath;	// 层次path
	private Integer level;			// 层级
	@Column(name = "create_time")
	private String createTime;		// 创建时间

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
	 * @return the pId
	 */
	public Integer getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(Integer pId) {
		this.pId = pId;
	}

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
	 * @return the categoryPath
	 */
	public String getCategoryPath() {
		return categoryPath;
	}

	/**
	 * @param categoryPath the categoryPath to set
	 */
	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
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

}
