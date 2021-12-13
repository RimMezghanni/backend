package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

@SpringBootApplication
@EnableDiscoveryClient
public class PublicationServiceApplication implements CommandLineRunner {
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
	IPublicationService publicationService;
    
	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Publication pub = new Publication();
		pub.setTitre("facebook");
		pub.setLieu("ville de sfax");
		publicationRepository.save(pub);

		Publication pub1 = new Publication();
		pub1.setTitre("instagram");
		pub1.setLieu("sousse");
		publicationRepository.save(pub1);

		Publication pub2 = new Publication();
		pub2.setTitre("twitter");
		pub2.setLieu("monastir");
		publicationRepository.save(pub2);

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = (Date) dateFormatter.parse("2020-05-05");
		Publication p = publicationService.findPublication(1L);
		p.setDate(date2);
		publicationService.updatePublication(p);

		Publication p1 = publicationService.findPublication(2L);
		p1.setSourcepdf("lien 1");
		publicationService.updatePublication(p1);

	}

}
