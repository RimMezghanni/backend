package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publication implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Long id;
	private String type;
	private String titre;
	private String lieu;
	private Date date;
	private String sourcepdf;

	public Publication() {
	}

	public Long getId() {
		return id;
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
