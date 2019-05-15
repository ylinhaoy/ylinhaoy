/** 
 * <pre>项目名称:maven_power_xinx 
 * 文件名称:SessionUserUtil.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月8日上午11:54:24 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.util;

import com.jk.xinx.pojo.user.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * <pre>项目名称：maven_power_xinx    
 * 类名称：SessionUserUtil    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月8日 上午11:54:24    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月8日 上午11:54:24    
 * 修改备注：       
 * @version </pre>    
 */
public class SessionUserUtil {

	public static UserBean getUserInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (UserBean) session.getAttribute(session.getId());
	}
}
