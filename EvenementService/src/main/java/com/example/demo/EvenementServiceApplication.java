package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

@SpringBootApplication
@EnableDiscoveryClient
public class EvenementServiceApplication implements CommandLineRunner {
	@Autowired
	EvenementRepository evenementRepository;
    @Autowired
    IEvenementService evenementService;
	public static void main(String[] args) {
		SpringApplication.run(EvenementServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      Evenement evt = new Evenement();
      evt.setLieu("foire");
      evt.setTitre("talent show");
      evenementRepository.save(evt);
      Evenement evt1 = new Evenement();
      evt1.setLieu("Salle de féte");
      evt1.setTitre("Gallerie");
      evenementRepository.save(evt1);
      Evenement evt2 = new Evenement();
      evt2.setLieu("espace libre");
      evt2.setTitre("piéce de théatre");
      evenementRepository.save(evt2);
      Evenement evt3 = new Evenement();
      evt3.setLieu("foire");
      evt3.setTitre("piéce musicale");
      evenementRepository.save(evt3);
      
      SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
      Date date2 = (Date) dateFormatter.parse("2020-05-05");
	  Evenement e = evenementService.findEvenement(1L);
	  e.setDate(date2);
	  evenementService.updateEvenement(e);
	 

	  //evenementService.deleteEvenement(1L);
	  
	 


			}
	

}
