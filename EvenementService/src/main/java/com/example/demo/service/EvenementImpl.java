package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Service
public class EvenementImpl implements IEvenementService {
	@Autowired
	EvenementRepository evenementRepository;
	@Override
	public Evenement addEvenement(Evenement e) {
		evenementRepository.save(e);
		return e;
	}

	@Override
	public void deleteEvenement(Long id) {
    if(evenementRepository.findById(id).get() != null) {
    	evenementRepository.deleteById(id);
    }
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		
		return evenementRepository.saveAndFlush(e);
	}

	@Override
	public Evenement findEvenement(Long id) {
		 Evenement e =(Evenement) evenementRepository.findById(id).get();
		 return (e);
   	}

	@Override
	public List<Evenement> findAll() {
		return evenementRepository.findAll();
	}
    @Override
	public List <Evenement> findByTitre(String titre) {
		return evenementRepository.findByTitre(titre);
	}

	@Override
	public List <Evenement> findByLieu(String lieu) {
		
		return evenementRepository.findByLieu(lieu);
	}

	@Override
	public List<Evenement> findByDate(Date date) {
		return evenementRepository.findByDate(date);
	}

}
