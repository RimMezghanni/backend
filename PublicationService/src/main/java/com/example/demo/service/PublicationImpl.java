package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;
@Service
public class PublicationImpl implements IPublicationService{
	@Autowired
	PublicationRepository publicationRepository;
	@Override
	public Publication addPublication(Publication p) {
		return publicationRepository.save(p);
	}

	@Override
	public void deletePublication(Long id) {
       if (publicationRepository.findById(id).get() != null)		{
    	   publicationRepository.deleteById(id);
       }
	}

	@Override
	public Publication updatePublication(Publication p) {
		return publicationRepository.saveAndFlush(p);
	}

	@Override
	public Publication findPublication(Long id) {
		return publicationRepository.findById(id).get();
	}

	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public List<Publication> findByTitre(String titre) {
		return publicationRepository.findByTitre(titre);
	}

	@Override
	public List<Publication> findByLieu(String lieu) {
		return publicationRepository.findByLieu(lieu);

	}

	@Override
	public List<Publication> findByDate(Date date) {
		return publicationRepository.findByDate(date);

	}

	@Override
	public List<Publication> findByType(String type) {
		return publicationRepository.findByType(type);

	}

	@Override
	public List<Publication> findBySourcePdf(String sourcepdf) {
		return publicationRepository.findBySourcepdf(sourcepdf);

	}
	

}
