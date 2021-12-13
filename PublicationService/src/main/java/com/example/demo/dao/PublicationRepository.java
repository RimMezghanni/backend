package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Date;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Publication;


@Repository
public interface PublicationRepository extends JpaRepository <Publication, Long>{
	List <Publication>findByType(String type);
	List <Publication>findByLieu(String lieu);
	List <Publication>findByTitre(String titre);
	List <Publication>findByDate(Date date);
	List <Publication>findBySourcepdf(String sourcepdf);



}
