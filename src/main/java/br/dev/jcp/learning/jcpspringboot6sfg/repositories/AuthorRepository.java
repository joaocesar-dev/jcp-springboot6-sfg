package br.dev.jcp.learning.jcpspringboot6sfg.repositories;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("SELECT a from Author a JOIN FETCH a.books")
    List<Author> listAllAuthors();
}