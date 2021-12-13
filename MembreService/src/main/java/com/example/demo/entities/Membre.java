package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING, length = 3)
public abstract class Membre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private Date date;
	protected byte photo;
	private String cv;
	private String email;
	private String password;

	public Membre() {
	};

	public Membre(String cin, String nom, String prenom, Date date, byte photo, String cv, String email,
			String password) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.photo = photo;
		this.prenom = prenom;
		this.date = date;

		this.cv = cv;
		this.email = email;
		this.password = password;
	}

	@Transient
	Collection<PublicationBean> pubs;

	@Transient
	Collection<OutilBean> outs;

	@Transient
	Collection<EvenementBean> evts;

	public Collection<OutilBean> getOuts() {
		return outs;
	}

	public void setOuts(Collection<OutilBean> outs) {
		this.outs = outs;
	}

	public Collection<EvenementBean> getEvts() {
		return evts;
	}

	public void setEvts(Collection<EvenementBean> evts) {
		this.evts = evts;
	}

	public Collection<PublicationBean> getPubs() {
		return pubs;
	}

	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte getPhoto() {
		return photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}