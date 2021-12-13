package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.MembreOutil;
import com.example.demo.entities.Membre_Outil_Ids;

public interface MemberOutilRepository extends JpaRepository<MembreOutil, Membre_Outil_Ids> {

	@Query("select l from MembreOutil l where auteur_id=:z")
	List<MembreOutil> findOutilId(@Param("z") Long autId);
}
