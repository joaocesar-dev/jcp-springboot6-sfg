package br.dev.jcp.learning.jcpspringboot6sfg.bootstrap;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Author;
import br.dev.jcp.learning.jcpspringboot6sfg.domain.Book;
import br.dev.jcp.learning.jcpspringboot6sfg.domain.Publisher;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.AuthorRepository;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.BookRepository;
import br.dev.jcp.learning.jcpspringboot6sfg.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

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

/*
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
*/

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

/*
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
*/

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

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

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

        //List<Author> authors = (List<Author>) authorRepository.findAll();
        List<Author> authors = (List<Author>) authorRepository.listAllAuthors();
        for (Author author : authors) {
            System.out.println("Author: " + author);
        }
    }

}
