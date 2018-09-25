package com.springframework.springapp1.repositories;
/*
Author: BeGieU
Date: 25.09.2018
*/

import com.springframework.springapp1.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Long>
{

}
