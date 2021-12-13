package com.example.demo.beans;

import java.util.Date;

public class OutilBean {
	private Long id;
	private Date date;
	private String source;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public OutilBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
