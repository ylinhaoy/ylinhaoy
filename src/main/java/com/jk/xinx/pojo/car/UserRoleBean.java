package com.jk.xinx.pojo.car;

public class UserRoleBean {
	
	private Integer id;
	
	private Integer userid;
	
	private Integer roleid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "UserRoleBean [id=" + id + ", userid=" + userid + ", roleid=" + roleid + "]";
	}

	
	
}
