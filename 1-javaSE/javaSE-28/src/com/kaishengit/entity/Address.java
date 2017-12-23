package com.kaishengit.entity;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String city;
	private String school;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	
	
}
