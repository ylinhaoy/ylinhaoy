package com.jk.xinx.util;

import java.util.UUID;

/** 
 * <pre>项目名称：upload_dmeo2    
 * 类名称：FileUtil    
 * 类描述：    
 * 创建人：辛旭  xuxin18519702347@163.com   
 * 创建时间：2018-9-3 上午9:32:57    
 * 修改人：辛旭  xuxin18519702347@163.com  
 * 修改时间：2018-9-3 上午9:32:57    
 * 修改备注：       
 * @version </pre>    
 */

public class StringUtil {
	
	/**
	 *  判断字符串是否为空，为空返回true，不为空返回false
	 * @param str 判断的字符串
	 * @return
	 */
	private static boolean isEmpty(String str){
		
		if(str == null || "".equals(str) || str.length() == 0){
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * 判断字符串不为空，不为空true ，为空则返回false
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		
		if(!isEmpty(str)){
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * 获取32位UUID字符串
	 * 
	 * */
	public static String getUUID() {
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		return uuid;
		
	}
	
	
	/**
	 * String 占位符 {}
	 */
	public static String format(String str,String...arr){
		for (int i = 0; i < arr.length; i++) {
			String oldStr = "\\{"+i+"\\}";
			String newStr = arr[i];
			String replaceAll = str.replaceAll(oldStr, newStr);
			str = replaceAll;
		}
		return str;
	}
	
	public static void main(String[] args) {
		String str = "我是{0},我来自{1},今年{2}岁";
		String[] arr = {"东北人","吉林省","28"};
		String format = format(str,arr);
		System.out.println(format);
	}

}
