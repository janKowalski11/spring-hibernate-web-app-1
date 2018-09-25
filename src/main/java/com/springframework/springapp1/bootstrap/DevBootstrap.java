package com.springframework.springapp1.bootstrap;
/*
Author: BeGieU
Date: 25.09.2018
*/

import com.springframework.springapp1.model.Author;
import com.springframework.springapp1.model.Book;
import com.springframework.springapp1.repositories.AuthorRepo;
import com.springframework.springapp1.repositories.BookRepo;
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

    @Autowired
    public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo)
    {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    private void initData()
    {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
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
