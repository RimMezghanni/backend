package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

@Service
public class OutilImpl implements IOutilService {
@Autowired
OutilRepository outilRepository;
	@Override
	public Outil addOutil(Outil o) {
		
		return outilRepository.save(o);
	}

	@Override
	public void deleteOutil(Long id) {
      if(outilRepository.findById(id).get() != null) {
    	  outilRepository.deleteById(id);
      }
	}

	@Override
	public Outil updateOutil(Outil o) {
		return outilRepository.saveAndFlush(o);
	}

	@Override
	public Outil findOutil(Long id) {
		return outilRepository.findById(id).get();
	}

	@Override
	public List<Outil> findAll() {
		return outilRepository.findAll();
	}

	@Override
	public List<Outil> findBySource(String source) {
		return outilRepository.findBySource(source);
	}

	@Override
	public List<Outil> findByDate(Date date) {
		return outilRepository.findByDate(date);
	}

}
