package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.MembreEvenement;
import com.example.demo.entities.Membre_Evt_Ids;

public interface MemberEvenementRepository extends JpaRepository<MembreEvenement, Membre_Evt_Ids> {

	@Query("select n from MembreEvenement n where auteur_id=:y")
	List<MembreEvenement> findEvtId(@Param("y") Long autId);
}
