package com.lyn.hibernate.sessionDemo;

import java.util.Date;

public class News {
	private Integer id;
	private String author;
	private String title;
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", author=" + author + ", title=" + title + ", date=" + date + "]";
	}
	
}
