/** 
 * <pre>项目名称:week_employee_client_xinx 
 * 文件名称:BeanUtil.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月24日下午6:57:12 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/** 
 * <pre>项目名称：week_employee_client_xinx    
 * 类名称：BeanUtil    
 * 类描述：  根据反射原理，对实体Bean进行处理  
 * 创建人：pp 
 * 创建时间：2019年4月24日 下午6:57:12    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月24日 下午6:57:12    
 * 修改备注：       
 * @version </pre>    
 */
public class BeanUtil {

	/**
	 * <pre>Bean2Map(将任意实体Bean转换成HashMap)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月24日 下午6:59:03    
	 * 修改人：辛旭
	 * 修改时间：2019年4月24日 下午6:59:03    
	 * 修改备注： 
	 * @param bean
	 * @return
	 * @throws Exception</pre>
	 */
	public static HashMap<String, Object> Bean2Map(Object bean) throws Exception{
		HashMap<String,Object> map = new HashMap<String, Object>();
		Class beanClass = bean.getClass();
		Field[] fields = beanClass.getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);
			String name = field.getName();
			Object object = field.get(bean);
			map.put(name, object);
		}
		return map;
	}
	
	/**
	 * <pre>Map2Bean(将HashMap转化成需要的实体Bean)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月24日 下午6:59:55    
	 * 修改人：辛旭
	 * 修改时间：2019年4月24日 下午6:59:55    
	 * 修改备注： 
	 * @param map
	 * @param bean
	 * @return
	 * @throws Exception</pre>
	 */
	public static Object Map2Bean(Map<String, Object> map,Object bean) throws Exception{
		Class beanclass = bean.getClass();
		Field[] fields = beanclass.getDeclaredFields();
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			Field field = beanclass.getDeclaredField(key);
			if (field == null) {
				continue;
			}
			field.setAccessible(true);
			field.set(bean, map.get(key));;
		}
		return bean;
	}
	
	/**
	 * <pre>copyProperties(通过反射将任意对象1的对应属性copy给任意对象2)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月24日 下午7:11:28    
	 * 修改人：辛旭
	 * 修改时间：2019年4月24日 下午7:11:28    
	 * 修改备注：  要求：两个对象的对应字段 属性名 和 类型 需要相同
	 * @param resource
	 * @param target
	 * @return
	 * @throws Exception</pre>
	 */
	public static Object copyProperties(Object resource,Object target) throws Exception{
		HashMap<String, Object> map = Bean2Map(resource);
		Object map2Bean = Map2Bean(map,target);
		return map2Bean;
	}
}
