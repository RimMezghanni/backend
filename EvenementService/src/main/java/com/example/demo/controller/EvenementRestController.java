package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

@RestController
public class EvenementRestController {
	@Autowired
	IEvenementService evenementService;
	
	

@RequestMapping(value = "/evenements", method = RequestMethod.GET)
public List<Evenement> findMembres() {
return evenementService.findAll();
}

@GetMapping(value = "/evenement/{id}")
public Evenement findOneMemberById(@PathVariable Long id) {
return evenementService.findEvenement(id);
}

@GetMapping(value = "/evenement/search/titre")
public  List <Evenement> findOneEvenementByTitre(@RequestParam String titre) {
return  evenementService.findByTitre(titre);
}

@GetMapping(value = "/evenement/search/lieu")
public List <Evenement> findOneEvenementByLieu(@RequestParam String lieu) {
return evenementService.findByLieu(lieu);

}
}
