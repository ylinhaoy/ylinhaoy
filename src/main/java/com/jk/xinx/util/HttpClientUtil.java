package com.jk.xinx.util;
 
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.jk.xinx.conf.CommonConf;
 
/**
 * 
 * <pre>项目名称：maven_power_xinx    
 * 类名称：HttpClientUtil    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月10日 下午1:46:57    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月10日 下午1:46:57    
 * 修改备注：       
 * @version </pre>
 */
public class HttpClientUtil {
	
	static CloseableHttpClient client = null;
	static {
		client = HttpClients.createDefault();
	}
	
	/**
	 * <pre>get(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月12日 下午1:48:06    
	 * 修改人：辛旭
	 * 修改时间：2019年4月12日 下午1:48:06    
	 * 修改备注： 
	 * @param url
	 * @param params
	 * @return</pre>
	 */
	public static String get(String url,HashMap<String, Object> params){
		try {
			HttpGet httpGet = new HttpGet();
			
			Set<String> keySet = params.keySet();
			
			StringBuffer stringBuffer = new StringBuffer();
			
			stringBuffer.append(url).append("?t=").append(System.currentTimeMillis());
			
			for (String key : keySet) {
				stringBuffer.append("&").append(key).append("=").append(params.get(key));
			}
			
			httpGet.setURI(new URI(stringBuffer.toString()));
			
			CloseableHttpResponse execute = client.execute(httpGet);
			
			int statusCode = execute.getStatusLine().getStatusCode();
			
			if (CommonConf.HTTP_CLIENT_SUCCESSFUL_STATUS_CODE != statusCode) {
				return "";
			}
			
			return EntityUtils.toString(execute.getEntity(), "utf-8");
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * <pre>get(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月10日 下午1:45:28    
	 * 修改人：辛旭
	 * 修改时间：2019年4月10日 下午1:45:28    
	 * 修改备注： 
	 * @param url 请求路径
	 * @param params 参数
	 * String ... params 不确定长度字符串数组
	 * @return</pre>
	 */
	public static String get(String url,String...params){
		try {
			HttpGet httpGet = new HttpGet();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(url);
			for (String string : params) {
				stringBuffer.append("/").append(string);
			}
			httpGet.setURI(new URI(stringBuffer.toString()));
			CloseableHttpResponse execute = client.execute(httpGet);
			int statusCode = execute.getStatusLine().getStatusCode();
			if (CommonConf.HTTP_CLIENT_SUCCESSFUL_STATUS_CODE != statusCode) {
				return "";
			}
			return EntityUtils.toString(execute.getEntity(), "utf-8");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * <pre>post(这里用一句话描述这个方法的作用)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月10日 下午1:45:16    
	 * 修改人：辛旭
	 * 修改时间：2019年4月10日 下午1:45:16    
	 * 修改备注： 
	 * @param url
	 * @param params
	 * @return</pre>
	 */
	public static String post(String url,HashMap<String, Object> params) {
		try {
			HttpPost httpPost = new HttpPost();
			httpPost.setURI(new URI(url));
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				NameValuePair e = new BasicNameValuePair(key, params.get(key).toString());
				parameters.add(e);
			}
			HttpEntity entity = new UrlEncodedFormEntity(parameters , "utf-8");
			httpPost.setEntity(entity);
			CloseableHttpResponse execute = client.execute(httpPost);
			int statusCode = execute.getStatusLine().getStatusCode();
			if (CommonConf.HTTP_CLIENT_SUCCESSFUL_STATUS_CODE != statusCode) {
				return "";
			}
			return EntityUtils.toString(execute.getEntity(), "utf-8");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 请求参数为json字符串
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String postJson(String url,HashMap<String, Object> params) throws Exception {
		HttpPost httpPost = new HttpPost();
		httpPost.setURI(new URI(url));
		String jsonString = JSON.toJSONString(params);
		StringEntity stringEntity = new StringEntity(jsonString,"utf-8");
		stringEntity.setContentEncoding("UTF-8");
		stringEntity.setContentType("application/json");//发送json数据需要设置contentType
		httpPost.setEntity(stringEntity);
		CloseableHttpResponse execute = client.execute(httpPost);
		int statusCode = execute.getStatusLine().getStatusCode();
		if (200 != statusCode) {
			return "";
		}
		return EntityUtils.toString(execute.getEntity(), "utf-8");
	}
	/**
	 * postJson使用示例代码
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String url = "http://localhost:8081/express/findProductList.do";
		HashMap<String, Object> params = new HashMap<String, Object>();
		HashMap<String, Object> searchinfo = new HashMap<String, Object>();
		searchinfo.put("productType", "手机测试");
		params.put("searchinfo", searchinfo);
		params.put("page", 2);
		
		String postJson = HttpClientUtil.postJson(url , params );
		System.out.println(postJson);
	}

}
