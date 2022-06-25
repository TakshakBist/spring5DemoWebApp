package com.spring5webapp.demo.bootstrap;

import com.spring5webapp.demo.Repositories.AuthorRepository;
import com.spring5webapp.demo.Repositories.BookRepository;
import com.spring5webapp.demo.Repositories.PublisherRepository;
import com.spring5webapp.demo.domain.Author;
import com.spring5webapp.demo.domain.Book;
import com.spring5webapp.demo.domain.Publisher;
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
            publisher.setName("SFG Publishing");
            publisher.setCity("St Petersburg");
            publisher.setState("FL");

            publisherRepository.save(publisher);

            System.out.println("Publisher Count: " + publisherRepository.count());

            Author takshak = new Author("Takshak", "Bist");
            Book ddd = new Book("Domain Driven Design", "123123");
            takshak.getBooks().add(ddd);
            ddd.getAuthors().add(takshak);

            ddd.setPublisher(publisher);
            publisher.getBooks().add(ddd);

            authorRepository.save(takshak);
            bookRepository.save(ddd);
            publisherRepository.save(publisher);

            Author rod = new Author("Rod", "Johnson");
            Book noEJB = new Book("J2EE Development without EJB", "3939459459");
            rod.getBooks().add(noEJB);
            noEJB.getAuthors().add(rod);

            noEJB.setPublisher(publisher);
            publisher.getBooks().add(noEJB);

            authorRepository.save(rod);
            bookRepository.save(noEJB);
            publisherRepository.save(publisher);

            System.out.println("Number of Books: " + bookRepository.count());
            System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        }
 }

