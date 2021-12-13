package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Outil implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto increment
	private Long id;
	private Date date;
	private String source;
	
	
	public Outil() {}


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


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	};
	
}

