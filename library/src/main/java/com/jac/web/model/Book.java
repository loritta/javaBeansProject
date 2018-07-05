package com.jac.web.model;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private int publishYear;
	private String picLink;
	
	public Book(int id, String title, String author, int publishYear, String picLink) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.picLink = picLink;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public String getPicLink() {
		return picLink;
	}
	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}
		
}
