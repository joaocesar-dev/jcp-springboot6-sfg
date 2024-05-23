package br.dev.jcp.learning.jcpspringboot6sfg.bootstrap;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Author;
import br.dev.jcp.learning.jcpspringboot6sfg.domain.Book;
import br.dev.jcp.learning.jcpspringboot6sfg.domain.Publisher;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.AuthorRepository;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.BookRepository;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class BootstrapData implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(BootstrapData.class);
    
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        dddSaved.setAuthors(Set.of(ericSaved));
        noEJBSaved.setAuthors(Set.of(rodSaved));

        ericSaved.setBooks(Set.of(dddSaved));
        rod.setBooks(Set.of(noEJBSaved));

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setName("O'Riley");
        publisher.setAddress("123 Main");
        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        
        logger.info("In Bootstrap");
        logger.info("Author Count: {}", authorRepository.count());
        logger.info("Book Count: {}", bookRepository.count());
        logger.info("Publisher Count: {}", publisherRepository.count());

        List<Author> authors = authorRepository.listAllAuthors();
        for (Author author : authors) {
            logger.info("Author: {}",  author);
        }
    }

}
