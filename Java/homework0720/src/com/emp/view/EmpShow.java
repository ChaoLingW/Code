package com.emp.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.emp.po.CommonEmployee;
import com.emp.po.Director;
import com.emp.po.Employee;
import com.emp.po.Manager;
import com.emp.service.EmdService;

/**
 * @Description: 与系统相关显示
 * @author chaoling
 * @date 2018年7月28日上午11:15:02
 */

public class EmpShow {

	static Scanner sc = new Scanner(System.in);// 与控制台交互
	static EmdService emdService = new EmdService();// 业务处理对象
	static String pathname = "emp.txt";
	public static void main(String[] args) {

		while (true) {

			// 显示选择菜单
			menu();
			// 接受输入
			String choice = sc.nextLine();

			switch (choice) {

			case "1":
				addEmployee();
				break;
			case "2":
				delEmployee();
				break;
			case "3":
				updateEmployee();
				break;
			case "4":
				queryEmployee();
				break;
			case "0":
				exit();
				break;
			default:
				System.out.println("输入错误");
				break;

			}
		}
	}

	/**
	 * @Description: 显示菜单  
	 * @throws
	 */
	private static void menu() {

		System.out.println("|---------------|");
		System.out.println("|-----1 增加-----|");
		System.out.println("|-----2 删除-----|");
		System.out.println("|-----3 修改-----|");
		System.out.println("|-----4 查询-----|");
		System.out.println("|-----0 退出-----|");
		System.out.println("|---------------|");
		System.out.println("请选择业务");

	}

	/**
	 * @Description: 添加显示 @throws
	 */
	private static void addEmployee() {

		System.out.println("请输入要添加的姓名");
		String name = sc.nextLine();
		// 获取当前name索引
		int index = emdService.isExist(name);
		// 为-1说明该name不存在可以继续添加
		if (index == -1) {
			// 参数0，并获取返回值，null或employee对象
			Employee employee = info(0, "add");
			// 为null输入信息有误不能继续添加
			if (employee != null) {
				boolean addRes = emdService.addEmployee(employee);
				// 接受返回值。判断是否添加成功
				if (addRes)
					System.out.println("添加成功");
				else
					System.out.println("添加失败");
			} else
				System.out.println("输入的信息有误！");
		} else // 该name已存在
			System.out.println("该名字已存在，请换个名字试试！");
	}

	/**
	 * @Description: 删除显示 
	 * @throws
	 */
	private static void delEmployee() {

		System.out.println("请输入要删除人的姓名");
		String name = sc.nextLine();
		// 接受删除操作的返回值
		int res = emdService.delEmployee(name);

		if (res == -1)
			System.out.println("此人不存在，无法删除");
		else if (res == 1)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");

	}

	/**
	 * @Description: 修改显示    
	 * @throws
	 */
	private static void updateEmployee() {

		System.out.println("请输入要修改人的姓名");
		String name = sc.nextLine();
	
		//判断此人是否存在
		int index = emdService.isExist(name);
		if(index == -1)
			System.out.println("此人不存在");
		else{
			//获取对象
			Employee employee = info(index, "update");
			if(employee != null){
				//获取修该结果
				boolean res = emdService.updateEmployee(employee, index);
				if(res)
					System.out.println("修改成功");
				else
					System.out.println("修改失败");
			} else{
				System.out.println("输入信息有误");
			}
		}
	}

	/**
	 * @Description: 查询显示   
	 * @throws
	 */
	private static void queryEmployee() {

		System.out.println("请输入员工姓名");
		String name = sc.nextLine();

		int index = emdService.isExist(name);

		if(index == -1)
			System.out.println("此人不存在");
		else
			emdService.queryEmployee(index).dispaly();
	}

	/**
	 * @Description: 退出显示     
	 * @throws
	 */
	private static void exit() {

		System.out.println("谢谢使用！");
		System.exit(0);
	}

	/**
	 * @Description: 接受输入，根据姓名进行判断，添加时若该姓名不存在则继续添加，修改时，若该姓名与其他姓名不冲突则可以继续添加，
	 *               即返回Employee对象， 否则返回null 
	 * @param oldIndex 
	 * @return 
	 * @throws
	 */
	public static Employee info(int oldIndex, String opereate) {

		System.out.print("请输入员工编号");
		String ID = sc.nextLine();

		System.out.print("请输入员工姓名");
		String name = sc.nextLine();
		// 获取当前name的索引
		// 输入的name不一致情况，即判断的name与现在输入的name不同
		int index = emdService.isExist(name);
		// 如果是添加操作，index不等于-1不允许添加
		if (opereate.equals("add"))
			if (index != -1) {
				System.out.println("该姓名已存在");
				return null;
			}

		// 如果是更新操作 index == -1 || index == oldIndex时允许继续添加
		if (opereate.equals("update"))
			if (index != -1 && index != oldIndex) {
				System.out.println("该姓名已存在");
				return null;
			}
		// 当index为-1时，表示不存在该名字，则可以继续添加
		// 当index等于oldIndex时，表示修改时只有一个此名字的name，就是它本身，即修改时可以不修改本身
		System.out.print("请输入员工职位（普通员工，经理，董事长）");
		String postition = sc.nextLine();
		// 判断职位是否为普通员工、经理或者董事长，不是输出职位错误 否则继续输入
		if (postition.equals("普通员工") || postition.equals("经理") || postition.equals("董事长")) {

			System.out.print("请输入员工请假天数");
			int holiday = sc.nextInt();

			System.out.print("请输入员工基本工资");
			double salary = sc.nextDouble();
			sc.nextLine();

			Employee employee = new Employee();
			// 根据不同的职位创建对应的对象
			if (postition.equals("普通员工"))
				employee = new CommonEmployee(ID, name, postition, holiday, salary);
			else if (postition.equals("经理"))
				employee = new Manager(ID, name, postition, holiday, salary);
			else
				employee = new Director(ID, name, postition, holiday, salary);
			// 返回对象
			return employee;
		} else
			System.out.println("输入的职位错误");

		// 名字已存在或输入的信息有误
		return null;
	}

}
