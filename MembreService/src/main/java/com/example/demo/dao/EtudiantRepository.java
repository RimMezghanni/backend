package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List <Etudiant>findByDiplome(String caractere);
	List <Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);
  

}
