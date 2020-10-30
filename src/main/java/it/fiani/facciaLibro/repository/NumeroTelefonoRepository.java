package it.fiani.facciaLibro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fiani.facciaLibro.entity.NumeroTelefono;

@Repository
public interface NumeroTelefonoRepository extends CrudRepository<NumeroTelefono, Long> {

}
