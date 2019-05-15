/** 
 * <pre>项目名称:maven_power_xinx 
 * 文件名称:CommonConf.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月7日下午7:23:33 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.conf;

/** 
 * <pre>项目名称：maven_power_xinx    
 * 类名称：CommonConf    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月7日 下午7:23:33    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月7日 下午7:23:33    
 * 修改备注：       
 * @version </pre>    
 */
public class CommonConf {

	/**
	 * 左侧导航树缓存键
	 */
	public static final String FIND_NAV_CACHE_KEY = "findTreeListByUser";
	
	/**
	 * 左侧导航树缓存时间
	 */
	public static final Long WEST_NAV_CACHE_OUT_TIME = 30L;
	
	/**
	 * 获取权限树缓存键
	 */
	public static final String FIND_POWER_TREE_CACHE_KEY = "findPowerTree";
	
	/**
	 * 新增时获取部门下拉树缓存键
	 */
	public static final String FIND_DEPT_TREE_CACHE_KEY = "findDeptList";
	
	/**
	 * 新增时获取部门下拉树缓存失效时间
	 */
	public static final Long FIND_DEPT_TREE_CACHE_OUT_TIME = 30L;
	
	/**
	 * 新增地区二级联动缓存key
	 */
	public static final String FIND_AREA_CACHE_KEY = "findAreaList";
	
	/**
	 * 新增角色下拉框缓存key
	 */
	public static final String FIND_ROLE_CACHE_KEY = "findRoleList";
	
	/**
	 * 新增时获取角色下拉框缓存失效时间
	 */
	public static final Long FIND_ROLE_CACHE_OUT_TIME = 1L;

	/**
	 * 获取权限树缓存失效时间
	 */
	public static final Long POWER_TREE_CACHE_OUT_TIME = 20L;
	
	/**
	 * 获取用户所拥有所有权限缓存键
	 */
	public static final String FIND_USER_ALL_POWER_URI_CACHA_KEY = "findAllPowerUrlByUser";
	
	/**
	 * 获取用户所拥有所有权限缓存过期时间
	 */
	public static final Long FIND_USER_ALL_POWER_URI_CACHA_OUT_TIME = 60L;
	
	/**
	 * HttpClient成功状态码
	 */
	public static final int HTTP_CLIENT_SUCCESSFUL_STATUS_CODE = 200;
	
	/**
	 * 物流免费接口路径
	 */
	public static final String FIND_DOS_INFO_URL = "http://www.kuaidi100.com/query";
	
	
	
	/**
	 * 快递鸟接口地址
	 */
	public static final String KDN_URL = "http://api.kdniao.com/Ebusiness/EbusinessOrderHandle.aspx";
	
	/**
	 * 快递鸟 EBUSINESS_ID
	 */
	public static final String KDN_EBUSINESSID = "1463503";
	
	/**
	 * 快递鸟 api key
	 */
	public static final String KDN_API_KEY = "170bf7a1-a93e-4ea7-90b5-073c08fee43b";
	
	/**
	 * 快递鸟请求类型
	 */
	public static final String KDN_REUEST_TYPE = "1002";
	
	/**
	 * 智能机器人Robot调用接口路径
	 */
	public static final String ROBOT_URL = "http://api.qingyunke.com/api.php";
	
	/**
	 * 智能机器人Robot固定参数 key
	 */
	public static final String ROBOT_KEY = "free";
	
	/**
	 * 智能机器人Robot 智能识别参数
	 */
	public  static final int ROBOT_APPID = 0;
	
	/**
	 * 智能机器人Robot 正确返回参数
	 */
	public  static final String ROBOT_RESULT = "0";
	
	/**
	 * 天气调用接口路径
	 */
	public  static final String WEATHER_URL = "http://t.weather.sojson.com/api/weather/city";
	
	/**
	 * 天气调用返回成功状态
	 */
	public  static final String WEATHER_SUCCESS_STATUS = "200";
	
	/**
	 * 秒滴接口调用路径  https://api.miaodiyun.com/20150822/affMarkSMS/sendSMS
	 */
	public static final String MIAOD_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	
	/**
	 * 秒滴接口调用 开发者主账号
	 */
	public static final String MIAOD_ACCOUNT_SID = "0d5f4ef1ab934ffea6dffd9c66223184";
	
	/**
	 * 秒滴接口调用 TOKEN   
	 */
	public static final String MIAOD_TOKEN = "5a57a159d2554320a9ab0123eb3bc41f";
	
	/**
	 * 秒滴接口调用  成功返回会码
	 */
	public static final String MIAOD_SUCCESS_STATUS = "00000";
	
	/**
	 * 秒滴接口调用  验证码缓存键  
	 */
	public static final String MIAOD_RADNDOM_CACHE_KEY = "sendRandomCode";
	
	/**
	 * 秒滴接口调用  验证码缓存失效时间
	 */
	public static final Long MIAOD_RADNDOM_CACHE_OUT_TIME = 5L;

	
	/**
	 * 秒滴接口调用  验证码发送成功后在对应用户缓存key
	 */
	public static final String MIAOD_USER_CACHE_KEY = "loginByPhone";

	/**秒滴接口调用  对应用户缓存失效时间
	 * 
	 */
	public static final long MIAOD_USER_CACHE_OUT_TIME = 5L;
}
