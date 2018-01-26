package com.kaishengit.entity;

public class Dept {

	private int id;
	private String deptName;
	private int pId; // TODO 用于显示ztree是不用修改pId的属性名称

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

}
