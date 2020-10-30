package it.fiani.facciaLibro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.fiani.facciaLibro.entity.Post;
import it.fiani.facciaLibro.entity.Utente;
import it.fiani.facciaLibro.service.PostService;
import it.fiani.facciaLibro.service.UtenteService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;

	@Autowired
	UtenteService utenteService;

	@GetMapping("/")
	public String indexPost(Model datiInOutput) {
		List<Post> listaPost = postService.mostraListaPost();
		datiInOutput.addAttribute("listaPost", listaPost);
		return "templates.facciaLibro/index-facciaLibro";
	}

	@GetMapping("/new")
	public String formPost() {
		return "templates.post/form-post";
	}

	@PostMapping("/")
	public String salvaPost(HttpServletRequest datiInInput) {
		String titolo = datiInInput.getParameter("titolo");
		String testoPost = datiInInput.getParameter("testoPost");
		Long idUtente = Long.parseLong(datiInInput.getParameter("idUtente"));

		Post nuovoPost = new Post();
		nuovoPost.setTitolo(titolo);
		nuovoPost.setTestoPost(testoPost);

		Utente utenteCreazione = utenteService.cercaUtentePerId(idUtente);
		nuovoPost.setUtenteCreazione(utenteCreazione);
		utenteCreazione.getListaPost().add(nuovoPost);

		postService.salva(nuovoPost);

		// scorro tutti i post
		// e selezioni solo quelli che come utenteCreazione, hanno l'utente che sto
		// cercando

		return "redirect:/post/";
	}

	@GetMapping("/{id}")
	public String idPost(@PathVariable Long id, Model datiInOutput) {
		Post post = postService.cercaPostPerId(id);
		datiInOutput.addAttribute("post", post);
		return "templates.post/dettagli-post";
	}

	@GetMapping("/{id}/delete")
	public String cancellaPost(@PathVariable Long id) {
		postService.cancellaPost(id);

		return "redirect:/post/";
	}

}
