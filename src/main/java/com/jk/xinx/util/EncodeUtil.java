/** 
 * <pre>项目名称:maven_power_xinx 
 * 文件名称:EncodeUtil.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月12日下午6:39:46 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

/** 
 * <pre>项目名称：maven_power_xinx    
 * 类名称：EncodeUtil    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月12日 下午6:39:46    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月12日 下午6:39:46    
 * 修改备注：       
 * @version </pre>    
 */
public class EncodeUtil {

	/**
	 * <pre>getUTF8Encode(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月12日 下午6:41:29    
	 * 修改人：辛旭
	 * 修改时间：2019年4月12日 下午6:41:29    
	 * 修改备注： 将字符串转化成utf-8编码格式
	 * @param str
	 * @return utf-8 String
	 * @throws UnsupportedEncodingException</pre>
	 */
	public static String getUTF8Encode(String str) throws UnsupportedEncodingException{
		return URLEncoder.encode(str, "utf-8");
	}
	
	
	/**
	 * <pre>getBASE64Encode(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月12日 下午6:46:43    
	 * 修改人：辛旭
	 * 修改时间：2019年4月12日 下午6:46:43    
	 * 修改备注： 将字符串转化成base64编码格式
	 * @param str
	 * @return base64 String</pre>
	 */
	public static String getBASE64Encode(String str){
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(str.getBytes());
	}
}
