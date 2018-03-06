package com.kaishengit.entity;

public class Account {

	private int id;
	private String name;
	private String email;
	private String password;
	private int money;
	private boolean enable;

	public Account() {
	}

	public Account(String name, String email, String password, int money, boolean enable) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.money = money;
		this.enable = enable;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", money="
				+ money + ", enable=" + enable + "]";
	}

}
