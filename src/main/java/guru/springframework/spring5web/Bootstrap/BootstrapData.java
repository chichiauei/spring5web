package guru.springframework.spring5web.Bootstrap;

import guru.springframework.spring5web.domain.Author;
import guru.springframework.spring5web.domain.Book;
import guru.springframework.spring5web.domain.Publisher;
import guru.springframework.spring5web.repositories.AuthorRepository;
import guru.springframework.spring5web.repositories.BookRepository;
import guru.springframework.spring5web.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository,
      BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("Started in Bootstrap");

    Publisher publisher = new Publisher();
    publisher.setName("Herlin");
    publisher.setCity("Amherst");
    publisher.setState("MA");
    publisher.setZip("01003");


    publisherRepository.save(publisher);


    System.out.println("Publisher count: " + publisherRepository.count());

    Author qi = new Author("Jiawei","Qi");
    Book pd = new Book("Pattern design","1234");
    qi.getBook().add(pd);
    pd.getAuthors().add(qi);
    pd.setPublisher(publisher);
    publisher.getBooks().add(pd);


    authorRepository.save(qi);
    bookRepository.save(pd);
    publisherRepository.save(publisher);


    Author mei = new Author("Lily","Mei");
    Book sah = new Book("Sea and hulu","4567");
    mei.getBook().add(sah);
    sah.getAuthors().add(mei);


    sah.setPublisher(publisher);
    publisher.getBooks().add(sah);

    authorRepository.save(mei);
    bookRepository.save(sah);
    publisherRepository.save(publisher);


    System.out.println("Started in Bootstrap");
    System.out.println("Number of books " + bookRepository.count());
    System.out.println("Publisher number of books " + publisher.getBooks().size());
  }
}
