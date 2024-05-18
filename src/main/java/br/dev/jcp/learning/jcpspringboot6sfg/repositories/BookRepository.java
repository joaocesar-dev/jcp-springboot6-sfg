package br.dev.jcp.learning.jcpspringboot6sfg.repositories;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}