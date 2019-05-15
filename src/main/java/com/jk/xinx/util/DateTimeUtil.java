/** 
 * <pre>项目名称:maven_power_xinx 
 * 文件名称:DateTimeUtil.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月10日下午1:29:44 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * <pre>项目名称：maven_power_xinx    
 * 类名称：DateTimeUtil    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月10日 下午1:29:44    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月10日 下午1:29:44    
 * 修改备注：       
 * @version </pre>    
 */
public class DateTimeUtil {

	/**
	 * <pre>getPastDate(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月10日 下午1:30:39    
	 * 修改人：辛旭
	 * 修改时间：2019年4月10日 下午1:30:39    
	 * 修改备注：获取之前任意天数的时间 
	 * @param past 数字，任意天数
	 * @return</pre>
	 */
	public static Date getBeforeDate(int past) {  
	    Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
	    Date today = calendar.getTime();  
	      
	    return today;  
	}
	/**
	 * <pre>format(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月10日 下午1:39:19    
	 * 修改人：辛旭
	 * 修改时间：2019年4月10日 下午1:39:19    
	 * 修改备注： 将时间转化成自定义格式字符串
	 * @param date
	 * @param format
	 * @return</pre>
	 */
	public static String format(Date date,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * <pre>format(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月10日 下午1:40:14    
	 * 修改人：辛旭
	 * 修改时间：2019年4月10日 下午1:40:14    
	 * 修改备注： 将日期格式对象转化成yyyyMMddHHmmss格式
	 * @param date
	 * @return</pre>
	 */
	public static String format(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(date);
	}

}
