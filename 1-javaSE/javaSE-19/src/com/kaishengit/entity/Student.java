package com.kaishengit.entity;

public class Student {

	private String name;
	private int age;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}


	
	
	
	@Override
	public boolean equals(Object obj) {
		// 如果两者内存地址相同
		if(this == obj) {
			return true;
		}
		
		// 参数如果为null，return false
		if(obj == null) {
			return false;
		}
		
		// 判断obj是不是Student类的对象，如果不是返回false
		if(!(obj instanceof Student)) {
			return false;
		}
		
		// 判断当前对象和obj的属性是否相等
		Student otherStu = (Student)obj;
		if(this.age != otherStu.getAge()) {
			return false;
		} 
		
		if(this.name == null) {
			if(otherStu.getName() != null) {
				return false;
			}
		} else {
			if(!this.name.equals(otherStu.getName())) {
				return false;
			}
		}
		
		
		return true;
	}
}
