package com.jk.xinx.pojo.car;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;


public class Car {

	private Integer cid;
	private String username;
	private Integer color;
	private Integer typeid;
	private Double price;
	private String people;
	private String ctime;
	private String cimg;
	private Integer status;
	private Integer cnumber;
	private String password;
	private String cpasswoed2;
	private String roleid;
	private String rolename;
    private Integer provincecode;
	
	private String provincename;
	
	private Integer citycode;
	
	private String cityname;
	
	private String startime;
	private String endtime;
	
	private String login_number;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Integer getProvincecode() {
		return provincecode;
	}
	public void setProvincecode(Integer provincecode) {
		this.provincecode = provincecode;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	public Integer getCitycode() {
		return citycode;
	}
	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCpasswoed2() {
		return cpasswoed2;
	}
	public void setCpasswoed2(String cpasswoed2) {
		this.cpasswoed2 = cpasswoed2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin_number() {
		return login_number;
	}
	public void setLogin_number(String login_number) {
		this.login_number = login_number;
	}
	
	
	
	

	
	
	
	
	
	
	
}
