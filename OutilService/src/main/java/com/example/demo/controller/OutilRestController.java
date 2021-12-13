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

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

@RestController
public class OutilRestController {
	

@Autowired
IOutilService outilService;

@RequestMapping(value = "/outils", method = RequestMethod.GET)
public List<Outil> findOutils() {
return outilService.findAll();
}

@GetMapping(value = "/outil/{id}")
public Outil findOutilById(@PathVariable Long id) {
return outilService.findOutil(id);
}

@GetMapping(value = "/outil/search/source")
public List <Outil> findOutilBySource(@RequestParam String source) {
return outilService.findBySource(source);
}

@GetMapping(value = "/outil/search/date")
public List <Outil> findOutilByDate(@RequestParam Date date) {
return outilService.findByDate(date);

}

}
