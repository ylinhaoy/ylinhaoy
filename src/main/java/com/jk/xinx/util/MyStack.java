/** 
 * <pre>项目名称:datacenter_xinx 
 * 文件名称:MyStack.java 
 * 包名:com.jk.xinx.util 
 * 创建日期:2019年4月27日上午9:51:09 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.xinx.util;


/** 
 * <pre>项目名称：datacenter_xinx    
 * 类名称：MyStack    
 * 类描述：    
 * 创建人：pp 
 * 创建时间：2019年4月27日 上午9:51:09    
 * 修改人：辛旭  xuxin18519702347@163.com
 * 修改时间：2019年4月27日 上午9:51:09    
 * 修改备注：       
 * @version </pre>    
 */
public class MyStack<T> {

	private T data[];//该栈用于存储T泛型的容器，以数组形式存储
	private int maxSize;//该栈存储容器的最大容量
	private int top;//指向栈顶的指针

	public int size(){
		return maxSize-1;
	}
	
	public int getTop() {
		return top;
	}
	
	
	public T top(){
		return data[top];
	}

	/**
	 * 初始化 栈 的同时  ，初始化泛型为T的数组，容量大小需要设置，初始指针指向-1，意为空栈
	 * <pre>创建一个新的实例 MyStack.    
	 *    
	 * @param size</pre>
	 */
	public MyStack(int size){
		this.maxSize = size;
		this.data = (T[]) new Object[size];//泛型数组不能直接new创建，需要使用Object来创建(其实一开始也可以直接使用Object来代替泛型)
		this.top = -1;//有的范例使用0，但这样会占用一个内存
	}
	
	/**
	 * <pre>isNull(判断是否为空栈)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月26日 上午9:03:19    
	 * 修改人：辛旭
	 * 修改时间：2019年4月26日 上午9:03:19    
	 * 修改备注： 
	 * @return</pre>
	 */
	public boolean isNull(){
		return (this.top == -1);
	}
	
	/**
	 * <pre>isFull(判断是否为满栈)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月26日 上午9:03:36    
	 * 修改人：辛旭
	 * 修改时间：2019年4月26日 上午9:03:36    
	 * 修改备注： 
	 * @return</pre>
	 */
	public boolean isFull(){
		return (this.top == this.maxSize-1);
	}
	
	/**
	 * <pre>push(压栈)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月26日 上午9:03:57    
	 * 修改人：辛旭
	 * 修改时间：2019年4月26日 上午9:03:57    
	 * 修改备注： 
	 * @param value
	 * @return</pre>
	 */
	public boolean push(T value){
		if (isFull()) {
			System.out.println("满栈,无法加入");
			return false;
		}
		data[++top] = value;
		System.out.println("放入第"+(top+1)+"个元素，元素为："+value);
		return true;
	}
	
	/**
	 * <pre>pop(弹栈)   
	 * 创建人：辛旭 xuxin18519702347@163.com
	 * 创建时间：2019年4月26日 上午9:04:07    
	 * 修改人：辛旭
	 * 修改时间：2019年4月26日 上午9:04:07    
	 * 修改备注： 
	 * @return</pre>
	 */
	public T pop(){
		if (isNull()) {
			System.out.println("空栈");
			return null;
		}
		T t = data[top];
		top--;
		return t;
	}

}
