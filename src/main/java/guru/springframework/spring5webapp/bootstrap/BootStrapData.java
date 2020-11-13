package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Package :  guru.springframework.spring5webapp.bootstrap
 * Created by jerom on 12/11/2020 at 18:00
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher oreilly = new Publisher("OReilly");

        Author eric = new Author("Eric", "Evans");
        oreilly.getAuthors().add(eric);
        Book ddd = new Book("Domain Driven Design", "123123");
        oreilly.getBooks().add(ddd);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(oreilly);

        Author rod = new Author("Rod", "Johnson");
        oreilly.getAuthors().add(rod);
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        oreilly.getBooks().add(noEJB);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(oreilly);

        System.out.println("Started in Boostrap");
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());



    }
}
