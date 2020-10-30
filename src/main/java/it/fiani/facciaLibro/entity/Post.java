package it.fiani.facciaLibro.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titolo;
	private String testoPost;
	private LocalDate dataCreazione;
	private LocalDateTime instanteCreazione;
	private LocalDateTime instanteUltimoAggiornamento;

	@ManyToOne
	private Utente utenteCreazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtenteCreazione() {
		return utenteCreazione;
	}

	public void setUtenteCreazione(Utente utenteCreazione) {
		this.utenteCreazione = utenteCreazione;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTestoPost() {
		return testoPost;
	}

	public void setTestoPost(String testoPost) {
		this.testoPost = testoPost;
	}

	public LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDateTime getInstanteCreazione() {
		return instanteCreazione;
	}

	public void setInstanteCreazione(LocalDateTime instanteCreazione) {
		this.instanteCreazione = instanteCreazione;
	}

	public LocalDateTime getInstanteUltimoAggiornamento() {
		return instanteUltimoAggiornamento;
	}

	public void setInstanteUltimoAggiornamento(LocalDateTime instanteUltimoAggiornamento) {
		this.instanteUltimoAggiornamento = instanteUltimoAggiornamento;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", titolo=" + titolo + ", testoPost=" + testoPost + ", dataCreazione=" + dataCreazione
				+ ", instanteCreazione=" + instanteCreazione + ", instanteUltimoAggiornamento="
				+ instanteUltimoAggiornamento + ", utenteCreazione=" + utenteCreazione + "]";
	}

}
