package com.hpe.java;

import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserManage {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {

			System.out.println("-----------用户管理----------");
			System.out.println("1.添加\t2.删除\t3.修改\t4查询\t5.查询全部\t0.退出");
			System.out.println("请选择业务：");

			String choice = sc.nextLine();

			switch (choice) {
			case "1":
				add();
				break;

			case "2":
				delete();
				break;

			case "3":
				update();
				break;

			case "4":
				select();
				break;

			case "5":
				selectAll();
				break;

			case "0":
				System.out.println("谢谢使用");
				System.exit(0);
				break;

			default:
				System.out.println("输入有误");
				break;
			}
		}
	}

	private static void add() {
		// 显示工作
		System.out.println("请输入用户名");
		String userName = sc.nextLine();

		System.out.println("请输入密   码");
		String password = sc.nextLine();

		System.out.println("请输入真实姓名");
		String realName = sc.nextLine();

		System.out.println("请输入年   龄");
		sc.nextLine();
		int age = sc.nextInt();
		
		User user = new User(0, userName, password, realName, age);
		int res = addUser(user);
		
		if(res > 0)
			System.out.println("添加成功");
		else
			System.out.println("添加失败");
	}

	// 像数据库中添加用户的方法
	// 参数： 包含：用户名、密码、真实姓名和年龄 User
	// 返回值： int（受影响的行数）
	private static int addUser(User user){
		
		//sql
		//insert into user(username,password,realname,age) values(?,?,?,?)
		Connection connection = getConnection();
		String sql = "insert into user(username,password,realname,age) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRealName());
			pstmt.setInt(4, user.getAge());

			row = pstmt.executeUpdate();// int 受影响的行数
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(connection);
		}
		return row;
	}
	
	//删除显示
	private static void delete() {

		System.out.println("请输入删除人的名字");
		String name = sc.nextLine();
		
		int res = deleteUser(name);
		
		if(res > 0)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");
		
		
	}

	//根据用户删除用户
	//参数：String 
	//返回值：int
	
	private static int deleteUser(String name){
		
		//delete from user where username = ?;
		Connection connection = getConnection();
		String sql = "delete from user where username = ?";
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, name);

			row = pstmt.executeUpdate();// int 受影响的行数
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(connection);
		}
		return row;
	}
	
	//修改显示
	private static void update() {
		
		System.out.println("请输入要修改的姓名");
		
		
	}

	//根据姓名查询显示
	private static void select() {

		System.out.println("请输入要查询的人的姓名");
		String name = sc.nextLine();
		
		
	}

	//根据姓名查询操作
	//参数：String
	//返回值：int
	private static User selectUser(String name){
		
		User user = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sql = "select * from user where username = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()){
				int id = resultSet.getInt(1);
				String userName = resultSet.getString(2);
				String password = resultSet.getString(3);
				String realName = resultSet.getString(4);
				int age = resultSet.getInt(5);
				
				user = new User(id, userName, password, realName, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(resultSet);
			close(pstmt);
			close(connection);
		}
		return user;
	}
	//根
	private static void selectAll() {
		

	}

	// 返回与数据库bigdata2的连接
	private static Connection getConnection() {

		String driver = "com.mysql.jdbc.Driver";
		String user = "root";// 用户名
		String password = "mysql";// 密码
		String url = "jdbc:mysql://localhost:3306/bigdata2?useUnicode=true&characterEncoding=utf-8";// 地址

		Connection connection = null;
		try {
			Class.forName(driver);// 参数是驱动类的全类名
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	// 关闭Connection
	public static void close(Connection connection) {

		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// 重载
	// 关闭Statement
	public static void close(Statement pstmt) {

		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// 重载
	// 关闭ResultSet
	public static void close(ResultSet resultSet) {

		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}

//对应user表的实体类
class User{
	
	private int id;
	private String userName;
	private String password;
	private String realName;
	private int age;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public User(int id, String userName, String password, String realName, int age) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.age = age;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", realName=" + realName
				+ ", age=" + age + "]";
	}
	
}
