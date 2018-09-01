package com.hpe.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 公共类 工具类
 * @author 30601
 *
 */
public class ToolUtil {
	private ToolUtil(){}
	
	public static final String LOGINUSER = "LOGINUSER";
	
	/**
	 * yyyy-MM-dd hh:ss:mm  格式的字符串，转化成日期。
	 * @param str
	 * @return
	 */
	public static LocalDateTime getDate(String str){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(str, df);
	}
	public static String getStrDate(LocalDateTime date){		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return date.format(df);
	}
	/**
	 * 转化为UNICODE编码。  // xxxServlet?method=show&name=张三&deptName=开发
	 * @param value
	 * @return
	 */
	public static String encode(String value){
		String newname = null;
		try {
			newname = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newname;
	}
	
	public static String decode(String value){
		String newName=null;
		try {
			newName = URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newName;
	}
}
