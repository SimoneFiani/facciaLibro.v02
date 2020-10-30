package it.fiani.facciaLibro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fiani.facciaLibro.entity.Utente;
import it.fiani.facciaLibro.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository utenteRepository;

	public List<Utente> mostraListaUtenti() {

		return (List<Utente>) utenteRepository.findAll();
	}

	public void salva(Utente utente) {

		System.out.println(utente);
		utenteRepository.save(utente);

	}

	public void cancellaUtente(Long id) {
		utenteRepository.deleteById(id);
	}

	public Utente cercaUtentePerId(Long id) {
		return utenteRepository.findById(id).get();

	}

	public Long numeroUtenti() {
		return utenteRepository.count();
	}

	public String cognomeUtenteConPiuPost() {
		List<Utente> listaUtenti = (List<Utente>) utenteRepository.findAll();

		System.out.println(listaUtenti.get(1).getListaPost().size());

		int count = 0;
		String cognome = "c'è un problema XD";

		for (Utente u : listaUtenti) {
			if (u.getListaPost().size() > count) {
				cognome = u.getCognome();
				count = u.getListaPost().size();
			}
		}

		return cognome;
	}

	public void convertiInDTO(Utente utente) {

	}

}
