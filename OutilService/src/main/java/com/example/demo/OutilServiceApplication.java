package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

@SpringBootApplication
@EnableDiscoveryClient
public class OutilServiceApplication implements CommandLineRunner {
	@Autowired
	IOutilService outilService;
	@Autowired
	OutilRepository outilRepository;

	public static void main(String[] args) {
		SpringApplication.run(OutilServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) dateFormatter.parse("2020-05-05");
		Outil outil = new Outil();
		outil.setSource("source1");
		outil.setDate(date);
		outilRepository.save(outil);

		Date date2 = (Date) dateFormatter.parse("2020-02-08");
		Outil outil1 = new Outil();
		outil1.setSource("source2");
		outil1.setDate(date2);
		outilRepository.save(outil1);
		Outil o = outilService.findOutil(1L);
		Date date3 = (Date) dateFormatter.parse("2020-08-01");
		o.setDate(date3);
		o.setSource("source1");
		outilService.updateOutil(o);

		Date date4 = (Date) dateFormatter.parse("2020-05-05");
		Outil outil3 = new Outil();
		outil3.setSource("source3");
		outil3.setDate(date4);
		outilRepository.save(outil3);

		outilService.deleteOutil(2L);

	}

}
