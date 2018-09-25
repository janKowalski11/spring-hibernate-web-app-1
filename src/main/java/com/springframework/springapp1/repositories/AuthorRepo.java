package com.springframework.springapp1.repositories;
/*
Author: BeGieU
Date: 25.09.2018
*/

import com.springframework.springapp1.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/*jesli klikniemy go to -> Implementations dla CrudRepository<T,ID>
* to wtedy pokaze nam implementacje interfejsu
* wtedy widac ze on juz ma kilka implementacji
* to z nich spring wybiera implementacje i 
* autowajruje  nam w klasie DevBootStrap*/
@Component
public interface AuthorRepo extends CrudRepository<Author,Long>
{
}
