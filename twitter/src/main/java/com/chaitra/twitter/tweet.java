package com.chaitra.twitter;

import java.util.List;

import com.chaitra.twitterDatabase.Link;

import java.util.ArrayList;
import java.util.Date;


public class tweet {
	private long id;
	private String author;
	private Date date;
	private String message;

	public tweet(int id, String author, String message) {
		super();
		this.id = id;
		this.author = author;
		this.message = message;
	}

	List<Link> linklist = new ArrayList<>();

	public List<Link> getLinklist() {
		return linklist;
	}

	public void setLinklist(List<Link> linklist) {
		this.linklist = linklist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addlink(String url, String ref) {
		Link link = new Link();
		link.setLink(url);
		link.setRef(ref);
		linklist.add(link);
	}
}
