package it.fiani.facciaLibro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fiani.facciaLibro.entity.Utente;

@Repository

public interface UtenteRepository extends CrudRepository<Utente, Long> {

}
