package br.dev.jcp.learning.jcpspringboot6sfg.services;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
