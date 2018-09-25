package com.springframework.springapp1.Controllers;
/*
Author: BeGieU
Date: 25.09.2018
*/

import com.springframework.springapp1.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Controllers
{

    private BookRepo bookRepo;

    @Autowired
    public Controllers(BookRepo bookRepo)
    {
        this.bookRepo = bookRepo;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("book",bookRepo.findAll());

        return "books";
    }
}
