package com.jk.xinx.pojo.car;

public class Weatherbean {

	private Integer id;
	private Integer pid;
	private String cityname;
	private String citycode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	@Override
	public String toString() {
		return "Weatherbean [id=" + id + ", pid=" + pid + ", cityname=" + cityname + ", citycode=" + citycode + "]";
	}
	
	
	
	
	

	
	
}
