package com.hpe.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

public class JdbcTest {
	Scanner sc = new Scanner(System.in);

	// 导入Java连接MySQL数据的jar包
	// 1.创建lib文件夹（用户存放jar包）
	// 2.添加类库到工程中，右键 build path --> add to build path
	@Test
	public void test1() throws ClassNotFoundException, SQLException {

		String driver = "com.mysql.jdbc.Driver";
		String user = "root";// 用户名
		String password = "mysql";// 密码
		String url = "jdbc:mysql://localhost:3306/bigdata2?useUnicode=true&characterEncoding=utf-8";// 地址

		// 如何连接数据库
		// 1.加载驱动并注册驱动类Driver
		Class.forName(driver);// 参数是驱动类的全类名

		// 2.获取与数据库的连接(Connection)
		// 用户名，密码，数据库地址
		// 数据库地址为localhost 3306 那么可以省略
		// java.sql包下的Connection
		Connection connection = DriverManager.getConnection(url, user, password);
	}

	@Test
	public void testInsert() {

		System.out.println("请输入用户名");
		String username = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();
		System.out.println("请输入真实姓名");
		String realname = sc.nextLine();
		System.out.println("请输入年龄");
		int age = sc.nextInt();

		// 向user表中插入一条记录zhangsan 123 张三 11
		// 1.获取与数据库bigdata2的连接
		Connection connection = getConnection();

		// 2.书写SQL语句
		String sql = "insert into user (username,password,realname,age) " + "values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			// 3.创建PreparedStatement对象(使用Connection创建),用于发送sql语句
			pstmt = connection.prepareStatement(sql);

			// 4.给占位符设置值
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, realname);
			pstmt.setInt(4, age);

			// 5.发送sql,让数据库执行
			// 增删改(更新)executeUpdate()
			int row = pstmt.executeUpdate();// int 受影响的行数

			if (row > 0)
				System.out.println("添加成功");
			else
				System.out.println("添加失败");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			close(pstmt);
			close(connection);
		}
	}

	@Test
	public void testDelete() {

		// 从控制台输入删除人的姓名，然后删除
		System.out.println("请输入删除人的姓名");
		String name = sc.nextLine();

		// 1 获取连接
		Connection connection = getConnection();
		// 2.写sql(占位符)
		String sql = "delete from user where username = ?";
		// 3.创建PreparedStatement
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			// 4.占位符赋值
			pstmt.setString(1, name);
			// 5执行更新
			int row = pstmt.executeUpdate();

			if (row > 0)
				System.out.println("删除成功");
			else
				System.out.println("删除失败");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			;
			close(connection);
		}
	}

	@Test
	public void testUpdate() {

		// 从控制台输入修改人的id，然后
		// 输入修改的信息：密码年龄
		System.out.println("请输入修改人的id" + "");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("请输入新的密码");
		String password = sc.nextLine();

		System.out.println("请输入新的年龄");
		int age = sc.nextInt();

		// 1 获取连接
		Connection connection = getConnection();
		// 2.写sql(占位符)
		String sql = "update user set password = ?, age = ? where id = ?";
		// 3.创建PreparedStatement
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			// 4.占位符赋值
			pstmt.setString(1, password);
			pstmt.setInt(2, age);
			pstmt.setInt(3, id);
			// 5执行更新
			int row = pstmt.executeUpdate();

			if (row > 0)
				System.out.println("修改成功");
			else
				System.out.println("修改失败");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			;
			close(connection);
		}
	}

	@Test
	public void testSelectOne() {

		// 从控制台输入要查询的id
		System.out.println("请输入要查询的id");
		String line = sc.nextLine();
		int id = Integer.parseInt(line);
		// 1.sql
		String sql = "select * from user where id = ?";

		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			// 2.Connection
			conn = getConnection();

			// 3.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 4.占位符赋值
			pstmt.setInt(1, id);
			// 5.执行查询executeQuery(),返回值ResultSet(结果集)
			resultSet = pstmt.executeQuery();

			// 6.遍历结果集，获取结果集中的数据
			if (resultSet.next()) {
				// 获取数据
				int idRez = resultSet.getInt("id");// sql语句中如果有别名，此处获取的是别名，否则可以是字段名，即必需时结果集中的列名
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				String realname = resultSet.getString(4);
				int age = resultSet.getInt(5);
				System.out.println(idRez + " " + username + " " + password + " " + realname + " " + age);
			} else {
				// 未查找到
				System.out.println("无此用户的id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(pstmt);
			close(conn);
		}
	}

	@Test
	public void testSelectAll() {

		// 1.sql
		String sql = "select * from user";
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			//2.Connection
			connection = getConnection();
			//3.PreparedStatement
			pstmt = connection.prepareStatement(sql);
			//4.占位符赋值
			//5.执行executeQuery(),得到ResultSet
			resultSet = pstmt.executeQuery();
			
			//6.遍历结果集
			while(resultSet.next()){
				// 获取数据
				int idRez = resultSet.getInt("id");// sql语句中如果有别名，此处获取的是别名，否则可以是字段名，即必需时结果集中的列名
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				String realname = resultSet.getString(4);
				int age = resultSet.getInt(5);
				System.out.println(idRez + " " + username + " " + password + " " + realname + " " + age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(pstmt);
			close(connection);
		}
	}

	// 返回与数据库bigdata2的连接
	public Connection getConnection() {

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
	public void close(Connection connection) {

		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// 重载
	// 关闭Statement
	public void close(Statement pstmt) {

		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// 关闭ResultSet
	public void close(ResultSet resultSet) {

		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
