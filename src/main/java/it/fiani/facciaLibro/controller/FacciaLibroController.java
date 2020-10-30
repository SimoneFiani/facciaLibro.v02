package it.fiani.facciaLibro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.fiani.facciaLibro.service.PostService;
import it.fiani.facciaLibro.service.UtenteService;

@Controller
@RequestMapping("/facciaLibro")
public class FacciaLibroController {

	@Autowired
	UtenteService utentiService;

	@Autowired
	PostService postService;

	@GetMapping("/")
	public String index(Model datiInOutput) {
		System.out.println("HIT /facciaLibro");
		return "redirect:/post/";
	}
}
