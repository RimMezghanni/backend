package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Publication;

@Service
public interface IPublicationService {
	// Crud sur les evenements
	public Publication addPublication(Publication p);

	public void deletePublication(Long id);

	public Publication updatePublication(Publication p);

	public Publication findPublication(Long id);

	public List<Publication> findAll();

	// Filtrage par propriété
	public List<Publication> findByTitre(String titre);

	public List<Publication> findByLieu(String lieu);

	public List<Publication> findByDate(Date date);
	public List<Publication> findByType(String type);

	public List<Publication> findBySourcePdf(String sourcepdf);
}
