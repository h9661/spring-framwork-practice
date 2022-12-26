package guru.springframwork.spring5webapp.bootstrap;

import guru.springframwork.spring5webapp.domain.Author;
import guru.springframwork.spring5webapp.domain.Book;
import guru.springframwork.spring5webapp.domain.Publisher;
import guru.springframwork.spring5webapp.repositories.AuthorRepository;
import guru.springframwork.spring5webapp.repositories.BookRepository;
import guru.springframwork.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        System.out.println("Started in Bootstrap");


        Publisher publisher = new Publisher();
        publisher.setAddressLine1("1234");
        publisher.setName("SFG p");
        publisher.setCity("St");
        publisher.setState("state");
        publisher.setZip("zip");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123456789");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(publisher);


        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
