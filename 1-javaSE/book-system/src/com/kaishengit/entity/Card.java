package com.kaishengit.entity;

public class Card {

	private int id;
	private String code;
	private String name;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	@Override
	public String toString() {
		return "Card [id=" + id + ", code=" + code + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
}
