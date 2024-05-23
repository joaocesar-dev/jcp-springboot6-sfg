package br.dev.jcp.learning.jcpspringboot6sfg.services;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Book;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
