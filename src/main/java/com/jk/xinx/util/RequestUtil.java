/** 
 * <pre>项目名称:maven_power_xinx 
 * 文件名称:RequestUtil.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月9日上午8:44:13 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/** 
 * <pre>项目名称：maven_power_xinx    
 * 类名称：RequestUtil    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月9日 上午8:44:13    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月9日 上午8:44:13    
 * 修改备注：       
 * @version </pre>    
 */
public class RequestUtil {

	public static HttpServletRequest getRequest(){
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
		
		if (sra == null) {
			return null;
		}
		return sra.getRequest();
	}
    
    
}
