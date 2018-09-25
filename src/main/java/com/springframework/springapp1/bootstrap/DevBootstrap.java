package com.springframework.springapp1.bootstrap;
/*
Author: BeGieU
Date: 25.09.2018
*/

import com.springframework.springapp1.model.Author;
import com.springframework.springapp1.model.Book;
import com.springframework.springapp1.model.Publisher;
import com.springframework.springapp1.repositories.AuthorRepo;
import com.springframework.springapp1.repositories.BookRepo;
import com.springframework.springapp1.repositories.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;


    /* wyjasnienie jakim chujem spring
    Implementuje interface a potem go autowired uje
    https://stackoverflow.com/a/43426005/9611203
    https://stackoverflow.com/q/38509882/9611203

    You autowire the interface so you can wire
     in a different implementation--that's one
     of the points of coding to the interface,
      not the class

     In the nutshell what happens is that Spring Data
    During the container bootstrap process scans
     for the all repositories interfaces;
     creates new classes (Proxies) which implement these interfaces;
     puts instances of those classes into the Spring container
       which allows for @Autowired to find and inject them as it
      would do for any other Spring bean within the container.
      */

    @Autowired
    public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo)
    {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    private void initData()
    {
        Publisher publisher1=new Publisher();
        publisher1.setName("Harper Collins");
        publisherRepo.save(publisher1);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);

        Publisher publisher2=new Publisher();
        publisher2.setName("Worx");
        publisherRepo.save(publisher2);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initData();
    }
}
