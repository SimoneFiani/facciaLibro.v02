package it.fiani.facciaLibro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fiani.facciaLibro.DTO.UtenteDTO;
import it.fiani.facciaLibro.entity.Utente;
import it.fiani.facciaLibro.service.PostService;
import it.fiani.facciaLibro.service.StatisticheService;
import it.fiani.facciaLibro.service.UtenteService;

@RestController
@RequestMapping("/posts/")
public class PostRestController {

	UtenteService utenteService;
	PostService postService;
	StatisticheService statisticheService;

	@Autowired
	public PostRestController(UtenteService utenteService, PostService postService,
			StatisticheService statisticheService) {

		this.utenteService = utenteService;
		this.postService = postService;
		this.statisticheService = statisticheService;
	}

	@GetMapping("/")
	public List<Utente> mostraLista() {
		return utenteService.mostraListaUtenti();
	}

	@PostMapping("/")
	public void salvaUtente(@RequestBody Utente utente) {
		utenteService.salva(utente);
	}

	@GetMapping("/{idUtente}")
	public UtenteDTO infoUtente(@PathVariable Long idUtente) {
		Utente utente = utenteService.cercaUtentePerId(idUtente);
		return convertiInDTO(utente);

	}

	@DeleteMapping("/{idUtente}")
	public Utente rimuoviUtente(@PathVariable Long idUtente) {
		return utenteService.cercaUtentePerId(idUtente);
	}

	private UtenteDTO convertiInDTO(Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setID(utente.getId());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		return utenteDTO;
	}
}
