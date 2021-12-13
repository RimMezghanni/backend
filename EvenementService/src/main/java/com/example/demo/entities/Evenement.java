package com.example.demo.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public  class  Evenement implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto increment
	private Long id;
	private String titre;
	private Date date;
	private String lieu;
	public Evenement() {};
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String t) {
		titre = t;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date d) {
		date = d;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String l) {
		lieu = l;
	}


}
