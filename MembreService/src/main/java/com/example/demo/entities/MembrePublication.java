package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class MembrePublication {
	@EmbeddedId
	private Membre_Pub_Ids id;
	@ManyToOne
	@MapsId("auteurid")
	private Membre auteur;
	public MembrePublication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MembrePublication(Membre_Pub_Ids id, Membre auteur) {
		super();
		this.id = id;
		this.auteur = auteur;
	}
	public Membre_Pub_Ids getId() {
		return id;
	}
	public void setId(Membre_Pub_Ids id) {
		this.id = id;
	}
	public Membre getAuteur() {
		return auteur;
	}
	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}

}
