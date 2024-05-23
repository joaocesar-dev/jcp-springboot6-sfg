package br.dev.jcp.learning.jcpspringboot6sfg.services;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
