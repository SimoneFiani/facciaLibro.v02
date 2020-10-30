package it.fiani.facciaLibro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fiani.facciaLibro.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
