package com.kaishengit.entity;

import java.util.List;

public class School {

	private int id;
	private String name;
	private String tel;
	private List<Student> stuList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", tel=" + tel + ", stuList=" + stuList + "]";
	}

}
