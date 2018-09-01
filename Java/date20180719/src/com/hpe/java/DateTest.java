package com.hpe.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	@Test
	public void test(){
		
		Date date = new Date();
		System.out.println(date);
		
		//转换为我们所需要的日期格式2017-01-01 19:20:20
		//SimpleDateFormat类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
		
		String dateStr1 = "2011-09-09 12:23:56";
		try {
			Date date2 = sdf.parse(dateStr1);
			System.out.println(date2);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date date1 = new Date(1000);//毫秒
		System.out.println(date1);
		
	}
	
	@Test
	public void test2(){
		
		Date date = new Date();
		long time = date.getTime();
		
		java.sql.Date date1 = new java.sql.Date(time);
		
	}
	
	
	
}
