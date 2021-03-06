package com.empmap.po;
/**
 * @Description: 员工类，实现对员工的管理，父类
 * @author chaoling
 * @date 2018年7月28日上午11:04:17
 */
public class Employee {
	
	private String ID;
	private String name;
	private String postition;
	private int holiday;
	private double salary;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostition() {
		return postition;
	}

	public void setPostition(String postition) {
		this.postition = postition;
	}

	public int getHoliday() {
		return holiday;
	}

	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}
	
	public Employee(String iD, String name, String postition, int holiday, double salary) {
		super();
		ID = iD;
		this.name = name;
		this.postition = postition;
		this.holiday = holiday;
		this.salary = salary;
	}

	public double sumSalary(){
		return this.salary *(30 - this.holiday)/30;
	}
	
	public void dispaly(){
		System.out.println("编号:" + ID + " 姓名:" + name + " 职务:" + postition + " 请假天数:" + holiday
				+ " 工资:" + sumSalary());
	}

	@Override
	public String toString() {
		return ID + "," + name + "," + postition + "," + holiday
				+ "," + salary ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (holiday != other.holiday)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postition == null) {
			if (other.postition != null)
				return false;
		} else if (!postition.equals(other.postition))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	
}
