package com.jk.xinx.pojo.car;

public class CarType {

	private Integer typeid;
	private String typename;
	
	
	
	public CarType(Integer typeid, String typename) {
		super();
		this.typeid = typeid;
		this.typename = typename;
		
		
	}
	public CarType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
