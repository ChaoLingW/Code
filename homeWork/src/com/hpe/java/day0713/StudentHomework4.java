package com.hpe.java.day0713;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午6:47:19
 * @Description
 */
/*生成3个学生实例，调用学生实例的showInfo方法,属性包含姓名，年龄，性别，学号
思路：
	1.创建一个学生类，
	2.在main去实例化（创建）三个学生对象。
	3.调用对象的showInfo方法，也就是说打印学生的信息
*/
public class StudentHomework4 {
	
	private String name;
	private int age;
	private String sex;
	private String no;
	
	//有参构造函数
	public StudentHomework4(String name, int age, String sex, String no) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.no = no;
	}


	public void showInfo(){
		//输出信息
		System.out.println("name=" + name + ", age=" + age + ", sex=" + sex + ", no=" + no);	
	}

}
