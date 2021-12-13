package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Membre_Evt_Ids implements Serializable {
	private Long auteur_id ;
	private Long evenement_id;
	public Membre_Evt_Ids() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Membre_Evt_Ids(Long auteur_id, Long evenement_id) {
		super();
		this.auteur_id = auteur_id;
		this.evenement_id = evenement_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur_id == null) ? 0 : auteur_id.hashCode());
		result = prime * result + ((evenement_id == null) ? 0 : evenement_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre_Evt_Ids other = (Membre_Evt_Ids) obj;
		if (auteur_id == null) {
			if (other.auteur_id != null)
				return false;
		} else if (!auteur_id.equals(other.auteur_id))
			return false;
		if (evenement_id == null) {
			if (other.evenement_id != null)
				return false;
		} else if (!evenement_id.equals(other.evenement_id))
			return false;
		return true;
	}
	public Long getAuteur_id() {
		return auteur_id;
	}
	public void setAuteur_id(Long auteur_id) {
		this.auteur_id = auteur_id;
	}
	public Long getEvenement_id() {
		return evenement_id;
	}
	public void setEvenement_id(Long evenement_id) {
		this.evenement_id = evenement_id;
	}

}
