package com.example.demo.beans;

import java.util.Date;

public class EvenementBean {
	private Long id;
	private String titre;
	private Date date;
	private String lieu;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}

	public EvenementBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
}
