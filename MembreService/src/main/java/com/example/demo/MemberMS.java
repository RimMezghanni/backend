package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxyService;
import com.example.demo.proxies.PublicationProxyService;
import com.example.demo.service.IMemberService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MemberMS implements CommandLineRunner {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	IMemberService memberService;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	@Autowired
	PublicationProxyService publicationProxyService;
	@Autowired
	OutilProxyService outilProxyService;

	@Autowired
	EvenementProxyService evenementProxyService;

	public static void main(String[] args) {
		SpringApplication.run(MemberMS.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Membre etd = new Etudiant();
		etd.setNom("baklouti");
		etd.setPrenom("marwa");
		memberRepository.save(etd);

		Membre etd1 = new Etudiant();
		etd1.setNom("mezghanni");
		etd1.setPrenom("rim");
		memberRepository.save(etd1);

		Membre etd2 = new Etudiant();
		etd2.setNom("smii");
		etd2.setPrenom("mariem");
		memberRepository.save(etd2);

		Membre ens = new EnseignantChercheur();
		ens.setNom("ahlem");
		memberRepository.save(ens);

		EnseignantChercheur ens1 = new EnseignantChercheur();
		ens1.setNom("ahmed");
		memberRepository.save(ens1);

		Membre m = memberService.findMember(3L);
		m.setCv("cv1.pdf");
		memberService.updateMember(m);
		Membre m1 = memberService.findMember(3L);
		m1.setCin("1111");
		memberService.updateMember(m1);
		Membre m3 = memberService.findMember(2L);
		m3.setCin("2222");
		memberService.updateMember(m3);

		Membre m2 = memberService.findMember(3L);
		m2.setEmail("mariem.mezghanni@enis.tn");
		memberService.updateMember(m2);
		memberService.deleteMember(1L);

		System.out.println(memberService.findByNom("baklouti"));

		System.out.println("heloo");

		/*
		 * SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); Date
		 * date2 = (Date) dateFormatter.parse("2020-05-05"); /*Etudiant ed3 = new
		 * Etudiant("111", "1222", "yyy", date2, (Byte) null, "azz", "zzz", "eeee",
		 * date2, "eeee", ens1);
		 * 
		 * memberRepository.save(ed3);
		 * 
		 * memberService.affecterEtudiantToEnseignant(3L, 2L);
		 */

		/*
		 * Membre etd4 = new Etudiant(); etd4.setNom("emna");
		 * etd4.setPrenom("khrifech"); memberRepository.save(etd4); //
		 * MembreRepository.save(etd); SimpleDateFormat dateFormatter = new
		 * SimpleDateFormat("yyyy-MM-dd"); Date date1 = (Date)
		 * dateFormatter.parse("2020/05/01"); /* Date date2 = (Date)
		 * dateFormatter.parse("2019-05-01"); Date date3 = (Date)
		 * dateFormatter.parse("2012-05-01"); Date date4 = (Date)
		 * dateFormatter.parse("2012-03-01"); Etudiant etd1 = new
		 * Etudiant("12345678","nom",date1,"","1","2","3",date2,"ss");
		 *
		 * Membre m = memberService.findMember(1L); m.setCv("cv1.pdf");
		 * memberService.updateMember(m);
		 */
// memberService.deleteMember(4L);
// memberService.deleteMember(3L);

		memberService.affecterEtudiantToEnseignant(3L, 5L);
		memberService.affecterEtudiantToEnseignant(2L, 4L);

		/*
		 * find etudiants encadré par 1 List <Etudiant> etds =
		 * etudiantRepository.findByEncadrant() System.out.print(etds.size());
		 * 
		 * /* Membre ens2= new EnseignantChercheur(); Membre ens1= new
		 * EnseignantChercheur("prof" ,"enis"); Membre etd5 = new Etudiant(date1,
		 * "eleve ingenieur", (EnseignantChercheur) ens1); memberRepository.save(etd5);
		 * memberRepository.save(ens2);
		 */
		/* memberService.affecterEtudiantToEnseignant(5L, 18L); */
		/* memberService.affecterEtudiantToEnseignant(6L, 19L); */

		/*
		 * //find etudians encadré par 1 List<Etudiant> etds =
		 * etudiantRepository.findByEncadrant(ens1); System.out.print(etds.size());
		 */

		// Tester Proxies
		PublicationBean pub = publicationProxyService.findPublicationById(1L);
		System.out.println(pub.getTitre() + " " + pub.getType());

		EvenementBean evt = evenementProxyService.findEvenementById(1L);
		System.out.println(evt.getLieu());

		OutilBean out = outilProxyService.findOutilById(1L);
		System.out.println(out.getSource());
		// affecter auteur a une pub
		memberService.affecterauteurTopublication(2L, 1L);
		memberService.affecterauteurTopublication(2L, 3L);
		memberService.affecterauteurTopublication(3L, 2L);
		memberService.affecterauteurToevenement(2L, 1L);
		memberService.affecterauteurToevenement(3L, 2L);
		memberService.affecterauteurTooutil(3L, 2L);
		memberService.affecterauteurTooutil(2L, 3L);


		// recupere pub pour id=2

		List<PublicationBean> lstpub = memberService.findPublicationparauteur(2L);
		lstpub.forEach(g -> System.out.println(g.getTitre())
		);
		
		// recupere pub pour id=2

		List<OutilBean> lstout = memberService.findOutilparauteur(2L);
		lstout.forEach(g -> System.out.println(g.getSource())
		);
		
		List<EvenementBean> lstevt = memberService.findEvenementparauteur(2L);
		lstevt.forEach(g -> System.out.println(g.getLieu())
		);


	}
}
