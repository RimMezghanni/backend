package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.service.IMemberService;

@RestController
public class MemberRestController {
	@Autowired
	IMemberService memberService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Membre> findMembres() {
		return memberService.findAll();
	}

	@GetMapping(value = "/membre/{id}")
	public Membre findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}

	@GetMapping(value = "/membre/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin) {
		return memberService.findByCin(cin);
	}

	@GetMapping(value = "/membre/search/email")
	public Membre findOneMemberByEmail(@RequestParam String email) {
		return memberService.findByEmail(email);
	}

	@GetMapping(value = "/membre/search/nom")
	public Membre findOneMemberByNom(@RequestParam String nom) {
		return (Membre) memberService.findByNom(nom);
	}

	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name = "id") Long id) {
		Membre mbr = memberService.findMember(id);
		mbr.setPubs(memberService.findPublicationparauteur(id));
		mbr.setOuts(memberService.findOutilparauteur(id));
		mbr.setEvts(memberService.findEvenementparauteur(id));
		return mbr;
	}
	@CrossOrigin(origins = "http://localhost:4200" , maxAge = 3600)

	
	@PostMapping(value = "/membre/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")


	@PostMapping(value = "/membre/etudiant")
	public Membre addMembre(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/membres/etudiant")
	public Membre affecter(@RequestParam Long idetd, @RequestParam Long idens) {

		return memberService.affecterEtudiantToEnseignant(idetd, idens);
	}

	@DeleteMapping(value = "/membres/{id}")
	public void deleteMembre(@PathVariable Long id) {
		memberService.deleteMember(id);
	}
}
