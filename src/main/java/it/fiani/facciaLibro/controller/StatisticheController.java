package it.fiani.facciaLibro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.fiani.facciaLibro.service.PostService;
import it.fiani.facciaLibro.service.UtenteService;

@Controller
@RequestMapping("/statistiche")

public class StatisticheController {

	@Autowired
	PostService postService;
	@Autowired
	UtenteService utenteService;

	@GetMapping("/")
	public String indexStatistiche(Model datiInOutput) {
		Long numeroPost = postService.numeroPost();
		datiInOutput.addAttribute("numeroPost", numeroPost);
		Long numeroUtentiRegistrati = utenteService.numeroUtenti();
		datiInOutput.addAttribute("numeroUtentiRegistrati", numeroUtentiRegistrati);
		String cognomeUtente = utenteService.cognomeUtenteConPiuPost();
		System.out.println(cognomeUtente);
		datiInOutput.addAttribute("cognomeUtenteConPiuPost", cognomeUtente);
		return "templates.statistiche/index-statistiche";
	}

}
