package com.kaishengit.entity;

public class Book {

	private int id;
	private String name;
	private String author;
	private String publish;
	private String isbn;
	private int total;
	private int currentNum;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}

}
