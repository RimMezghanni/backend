package com.example.demo.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@DiscriminatorValue("etd")//valeur type mbr class membre
public class Etudiant extends Membre implements Serializable {
@Temporal(TemporalType.DATE)//donne le forme de date qu'on veut
private Date dateInscription;
private String diplome;
public Etudiant(){};
/*public Etudiant(String string, String string2, Date date1, String string3, String string4, String string5,
String string6, Date date2, String string7) {
// TODO Auto-generated constructor stub
}

public Etudiant(Long id, String cin, String nom, String prenom, Date date, byte photo, String cv, String email,
String password) {
super(id, cin, nom, prenom, date, photo, cv, email, password);
// TODO Auto-generated constructor stub
}
*/
@ManyToOne
private EnseignantChercheur encadrant;

public Etudiant( String cin, String nom, String prenom, Date date, byte photo, String cv, String email,
String password,Date dateInscription, String diplome, EnseignantChercheur encadrant) {
super(cin,nom,prenom,date,photo,cv, email,password);
this.dateInscription = dateInscription;
this.diplome = diplome;
this.encadrant = encadrant;
}



public EnseignantChercheur getEncadrant() {
return encadrant;
}

public void setEncadrant(EnseignantChercheur encadrant) {
this.encadrant = encadrant;
}

public Date getDateInscription() {
return dateInscription;
}

public void setDateInscription(Date dateInscription) {
this.dateInscription = dateInscription;
}

public String getDiplome() {
return diplome;
}

public void setDiplome(String diplome) {
this.diplome = diplome;
}

}