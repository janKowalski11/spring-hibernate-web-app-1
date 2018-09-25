package com.springframework.springapp1.repositories;
/*
Author: BeGieU
Date: 25.09.2018
*/

import com.springframework.springapp1.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,Long>
{
}
