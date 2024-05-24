package br.dev.jcp.learning.jcpspringboot6sfg.services;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Author;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
