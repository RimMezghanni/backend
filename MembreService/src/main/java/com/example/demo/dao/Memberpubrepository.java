package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MembrePublication;
import com.example.demo.entities.Membre_Pub_Ids;

public interface Memberpubrepository extends JpaRepository<MembrePublication, Membre_Pub_Ids> {
	@Query("select m from MembrePublication m where auteur_id =:t")
	List<MembrePublication> findPubId (@Param("t") Long autId);
}
