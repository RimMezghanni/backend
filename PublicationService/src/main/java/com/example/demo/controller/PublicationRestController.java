package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;
@RestController

public class PublicationRestController {
	

@Autowired
IPublicationService publicationService;

@RequestMapping(value = "/publications", method = RequestMethod.GET)
public List<Publication> findPublications() {
return publicationService.findAll();
}

@GetMapping(value = "/publication/{id}")
public Publication findPublicationById(@PathVariable Long id) {
return publicationService.findPublication(id);
}

@GetMapping(value = "/publication/search/lieu")
public List <Publication> findPublicationByLieu(@RequestParam String lieu) {
return  publicationService.findByLieu(lieu);
}

@GetMapping(value = "/publication/search/type")
public List <Publication> findPublicationByType(@RequestParam String type) {
return publicationService.findByType(type);

}

@GetMapping(value = "/publication/search/date")
public List <Publication> findPublicationByDate(@RequestParam Date date) {
return publicationService.findByDate(date);

}
@GetMapping(value = "/publication/search/titre")
public List <Publication> findPublicationByTitre(@RequestParam String titre) {
return publicationService.findByTitre(titre);

}
@GetMapping(value = "/publication/search/sourcepdf")
public List <Publication> findPublicationBySourcePdf(@RequestParam String sourcepdf) {
return publicationService.findBySourcePdf(sourcepdf);

}
}


