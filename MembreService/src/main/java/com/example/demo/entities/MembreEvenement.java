package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class MembreEvenement {
	@EmbeddedId
	private Membre_Evt_Ids id;
	@ManyToOne @MapsId("auteur_id")
	private Membre auteur;
	public MembreEvenement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MembreEvenement(Membre_Evt_Ids id, Membre auteur) {
		super();
		this.id = id;
		this.auteur = auteur;
	}
	public Membre_Evt_Ids getId() {
		return id;
	}
	public void setId(Membre_Evt_Ids id) {
		this.id = id;
	}
	public Membre getAuteur() {
		return auteur;
	}
	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}

}
