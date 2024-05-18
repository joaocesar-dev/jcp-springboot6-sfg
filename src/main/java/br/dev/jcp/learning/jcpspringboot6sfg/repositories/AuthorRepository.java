package br.dev.jcp.learning.jcpspringboot6sfg.repositories;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}