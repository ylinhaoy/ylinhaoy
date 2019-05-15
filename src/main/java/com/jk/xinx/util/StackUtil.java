/** 
 * <pre>项目名称:datacenter_xinx 
 * 文件名称:StackUtil.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月27日上午9:56:02 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.util;

import com.jk.xinx.util.MyStack;


/** 
 * <pre>项目名称：datacenter_xinx    
 * 类名称：StackUtil    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月27日 上午9:56:02    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月27日 上午9:56:02    
 * 修改备注：       
 * @version </pre>    
 */
public class StackUtil {

	/**
	 * <pre>popAll(依次弹出所有元素，返回元素组成的数组)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月27日 上午8:45:07    
	 * 修改人：辛旭
	 * 修改时间：2019年4月27日 上午8:45:07    
	 * 修改备注： 
	 * @param stack
	 * @return</pre>
	 */
	public static Object[] popAll(MyStack<?> stack){
		if (stack.isNull())
			return null;
		Object[] arr = new Object[stack.getTop()+1];
		int i = 0;
		while(!stack.isNull()){
			arr[i] = stack.pop();
			i++;
		}
		return arr;
	}
	
	/**
	 * <pre>integerToNhex(将十进制转化成二进制、八进制、十六进制，返回字符串)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月27日 上午9:54:00    
	 * 修改人：辛旭
	 * 修改时间：2019年4月27日 上午9:54:00    
	 * 修改备注： 
	 * @param num
	 * @param hex
	 * @return</pre>
	 */
	public static String integerToNhex(Integer num,Integer hex){
		if (hex != 2 && hex != 8 && hex != 16) 
			return "请输入有效的数字";
		if (num == 0)
			return "0";
		if (num > 0) {
			MyStack<Integer> stack = new MyStack<Integer>(16);
			while(num != 0){
				int mod = num % hex;
				num = num / hex;
				stack.push(mod);
			}
			Object[] popAll = popAll(stack);
			StringBuffer sb = new StringBuffer();
			for (Object object : popAll) {
				int i = (int) object;
				if (i >= 10) {
					char c = (char)('a'+(i-10));
					sb.append(c);
				}else{
					char c = (char) i;
					sb.append(c);
				}
			}
			return sb.toString();
		}else{
			num = -num;
			MyStack<Integer> stack = new MyStack<Integer>(16);
			while(num != 0){
				int mod = num % hex;
				num = num / hex;
				stack.push(mod);
			}
			Object[] popAll = popAll(stack);
			StringBuffer sb = new StringBuffer();
			sb.append("-");
			for (Object object : popAll) {
				int i = (int) object;
				if (i >= 10) {
					char c = (char)('a'+(i-10));
					sb.append(c);
				}else{
					char c = (char) i;
					sb.append(c);
				}
			}
			return sb.toString();
		}
	}
	
	/**
	 * <pre>isMatch(检查传入的字符串中的括号是否匹配)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月27日 上午11:05:45    
	 * 修改人：辛旭
	 * 修改时间：2019年4月27日 上午11:05:45    
	 * 修改备注： 
	 * @param str
	 * @return</pre>
	 */
	public static Boolean isMatch(String str){
		
		MyStack<Character> stack = new MyStack<Character>(str.length()+1);
		//将传入的字符串转化成字符数组
		char[] arr = str.toCharArray();
		
		for (char c : arr) {

			//判断，左括号压栈
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}
			
			if (c == ')') {
				//空栈，不匹配
				if (stack.isNull()) {
					return false;
				}
				//匹配，继续下一次迭代
				if (stack.pop() == '(') {
					continue;
				}
				//不符合，括号匹配规则
				return false;
			}
			
			if (c == ']') {
				//空栈，不匹配
				if (stack.isNull()) {
					return false;
				}
				//匹配，继续下一次迭代
				if (stack.pop() == '[') {
					continue;
				}
				//不符合，括号匹配规则
				return false;
			}
			
			if (c == '}') {
				//空栈，不匹配
				if (stack.isNull()) {
					return false;
				}
				//匹配，继续下一次迭代
				if (stack.pop() == '{') {
					continue;
				}
				//不符合，括号匹配规则
				return false;
			}
		}
		//如果最后没有右括号但是栈中还存在左括号表示不匹配
		return stack.isNull();
	}
	
	/**
	 * <pre>sort(通过另外一个栈对传入的栈进行升序排序)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月27日 下午1:48:56    
	 * 修改人：辛旭
	 * 修改时间：2019年4月27日 下午1:48:56    
	 * 修改备注： 
	 * @param stack
	 * @return</pre>
	 */
	public static MyStack<Integer> ascSort(MyStack<Integer> stack){
		MyStack<Integer> temp = new MyStack<Integer>(stack.size());
		while(!stack.isNull()){
			Integer pop = stack.pop();
			while(!temp.isNull() && temp.top() > pop){
				stack.push(temp.pop());
			}
			temp.push(pop);
		}
		return temp;
	}
	

}
