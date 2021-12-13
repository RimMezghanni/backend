package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberEvenementRepository;
import com.example.demo.dao.MemberOutilRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.Memberpubrepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.MembreEvenement;
import com.example.demo.entities.MembreOutil;
import com.example.demo.entities.MembrePublication;
import com.example.demo.entities.Membre_Evt_Ids;
import com.example.demo.entities.Membre_Outil_Ids;
import com.example.demo.entities.Membre_Pub_Ids;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxyService;
import com.example.demo.proxies.PublicationProxyService;

@Service
public class MemberImpl implements IMemberService {
	@Autowired
	MemberRepository memberRepositry;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	@Autowired
	Memberpubrepository memberpubrepository;

	@Autowired
	MemberEvenementRepository memberevenementrepository;

	@Autowired
	MemberOutilRepository memberoutilrepository;
	@Autowired
	PublicationProxyService publicationproxyService;

	@Autowired
	EvenementProxyService evenementproxyService;
	@Autowired
	OutilProxyService outilproxyService;

	
	@Override
	public Membre addMember(Membre m) {
		memberRepositry.save(m);
		return m;
	}

	@Override
	public void deleteMember(Long id) {
		if (memberRepositry.findById(id).get() != null) {
			memberRepositry.deleteById(id);
		}

	}

	@Override
	public Membre updateMember(Membre p) {

		return memberRepositry.saveAndFlush(p);
	}

	@Override
	public Membre findMember(Long id) {
		Membre m = (Membre) memberRepositry.findById(id).get();
		return m;
	}

	@Override
	public List<Membre> findAll() {

		return memberRepositry.findAll();
	}

	@Override
	public Membre findByCin(String cin) {

		return memberRepositry.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {

		return memberRepositry.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {

		return memberRepositry.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {

		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {

		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {

		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public Etudiant affecterEtudiantToEnseignant(Long idEtd, Long idEns) {
		Etudiant etd = etudiantRepository.findById(idEtd).get();
		EnseignantChercheur ens = enseignantChercheurRepository.findById(idEns).get();
		etd.setEncadrant(ens);
		return etudiantRepository.save(etd);
	}

	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr = memberRepositry.findById(idauteur).get();
		MembrePublication mbs = new MembrePublication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Ids(idpub, idauteur));
		memberpubrepository.save(mbs);

	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();
		List<MembrePublication> idpubs = memberpubrepository.findPubId(idauteur);
		idpubs.forEach(s ->
		pubs.add(publicationproxyService.findPublicationById((s.getId().getPublication_id()))));
		return pubs;

	}


	@Override
	public void affecterauteurToevenement(Long idauteur, Long idevt) {
		Membre mbr = memberRepositry.findById(idauteur).get();
		MembreEvenement mbs = new MembreEvenement();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Evt_Ids(idevt, idauteur));
		memberevenementrepository.save(mbs);

	}

	@Override
	public List<EvenementBean> findEvenementparauteur(Long idauteur) {
		List<EvenementBean> evts = new ArrayList<EvenementBean>();
		List<MembreEvenement> idevts = memberevenementrepository.findEvtId(idauteur);

		idevts.forEach(s ->

		evts.add(evenementproxyService.findEvenementById((s.getId().getEvenement_id()))));

		return evts;
	}

	@Override
	public void affecterauteurTooutil(Long idauteur, Long idout) {
		// TODO Auto-generated method stub
		Membre mbr = memberRepositry.findById(idauteur).get();
		MembreOutil mbs = new MembreOutil();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Outil_Ids(idout, idauteur));
		memberoutilrepository.save(mbs);

	}

	@Override
	public List<OutilBean> findOutilparauteur(Long idauteur) {
		List<OutilBean> outs = new ArrayList<OutilBean>();
		List<MembreOutil> idouts = memberoutilrepository.findOutilId(idauteur);

		idouts.forEach(s ->

		outs.add(outilproxyService.findOutilById((s.getId().getOutil_id()))));

		return outs;
	}

}
