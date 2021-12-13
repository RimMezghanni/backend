package com.example.demo.beans;

import java.util.Date;

public class PublicationBean {

	private Long id;
	private String type;
	private String titre;
	private String lieu;
	private Date date;
	private String sourcepdf;
	public PublicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	
	public PublicationBean(String type, String titre, Date date) {
		super();
		this.type = type;
		this.titre = titre;
		this.date = date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSourcepdf() {
		return sourcepdf;
	}
	public void setSourcepdf(String sourcepdf) {
		this.sourcepdf = sourcepdf;
	}
}
