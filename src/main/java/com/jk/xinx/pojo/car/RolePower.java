package com.jk.xinx.pojo.car;

public class RolePower {

	private Integer id;
	private Integer roleid;
	private Integer powerid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getPowerid() {
		return powerid;
	}
	public void setPowerid(Integer powerid) {
		this.powerid = powerid;
	}
	@Override
	public String toString() {
		return "RolePower [id=" + id + ", roleid=" + roleid + ", powerid=" + powerid + "]";
	}
	
}
