package com.hpe.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hpe.po.Telephone;

/*
 * 电话本管理的业务类
 */
public class TelService {

	List<Telephone> tels = new ArrayList<>();

	/*
	 * // 添加电话本业务 // 参数：Telephone，代表的电话本 // 返回值：int 1 添加成功 0 添加失败 -1 此人不存在
	 * public int addTel(Telephone telephone) {
	 * 
	 * // 判断能否添加,即查看是否存在此名称二分电话本，如果此名称的电话本已存在 int index =
	 * selectIndexByName(telephone.getName());
	 * 
	 * if (index != -1) { // 查到此人 return -1;
	 * 
	 * } else { // 添加电话本 if (tels.add(telephone)) return 1; else return 0; }
	 * if(selectIndexByName(telephone.getName())!= -1) return -1;
	 * 
	 * return tels.add(telephone) ? 1 : 0;
	 * 
	 * }
	 */

	// 添加电话本业务
	// 参数：Telephone，代表的电话本
	// 返回值：true  添加成功  false 添加失败 
	public boolean addTel(Telephone telephone) {

		return tels.add(telephone) ? true : false;

	}

	// 根据姓名删除电话本
	// 参数：String，代表的电话本
	// 返回值：false 此人不存在 true 删除成功
	public boolean deleteTelByName(String name) {
		int index = selectIndexByName(name);
		if (index == -1)
			return false;
		tels.remove(index);
		return true;

	}

	// 根据姓名更新电话本
	// 参数 Telephone int
	// 返回值 boolean
	public boolean updateTel(Telephone telephone, int index) {

		Telephone tel = tels.set(index, telephone);

		if (tel != null)
			return true;

		return false;

	}

	// 查询所有电话本业务
	// 参数：无参
	// 返回值：List<Telephone>
	public List<Telephone> selectAllTel() {

		return tels;

	}

	// 根据姓名查询
	// 参数：String
	// 返回值：Telephone
	public Telephone selectTelByName(String name) {

		// 1.得到此名字电话本的索引
		int index = selectIndexByName(name);

		// 如果不等于-1 找到了，返回具体的电话本
		if (index != -1) {
			return tels.get(index);
		}
		// 没找到，返回null
		return null;
	}

	public int selectIndexByName(String name) {

		// 遍历查找，存在返回索引
		for (int i = 0; i < tels.size(); i++) {
			if (tels.get(i).getName().equals(name))
				return i;
		}
		// 不存在返回-1
		return -1;

	}

	
	public void init(String path) {
		
		//读取记事本中的数据，(一行转换为Telephone对象，并将这个对象放到tels),只执行一次(程序刚开始执行的时候)
		BufferedReader br = null;
		try {
			File  file = new File(path);
			//判断文件是否存在，若不存在，则创建
			if(!file.exists())
				file.createNewFile();
			
			br = new BufferedReader(new FileReader(file));
			String line = null;
			
			while((line = br.readLine()) != null){
				
				String[] info = line.split(",");
				Telephone telephone = new Telephone(info[0], info[1], Integer.parseInt(info[2]), info[3], info[4], info[5]);
				//将telephone对象添加到tels
				tels.add(telephone);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	//退出应用的时候，将tels中的数据写到文件中
	public void save(String path) {
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(path));
			
			for(Telephone telephone : tels){
				bw.write(telephone.message());
				bw.newLine();
				bw.flush();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}
