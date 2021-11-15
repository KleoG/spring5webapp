package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

        Publisher publisher = new Publisher("Address", "POSTCODE");


        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Book", "isbn");


        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);

        bookRepository.save(book);


        Author eric2 = new Author("Eric2", "Evans2");
        Book book2 = new Book("Book2", "isbn2");

        eric2.getBooks().add(book2);
        book2.getAuthors().add(eric2);

        authorRepository.save(eric2);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");


    }
}
