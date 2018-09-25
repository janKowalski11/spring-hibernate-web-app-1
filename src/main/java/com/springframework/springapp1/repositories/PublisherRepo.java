package com.springframework.springapp1.repositories;
/*
Author: BeGieU
Date: 25.09.2018
*/

import com.springframework.springapp1.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PublisherRepo extends CrudRepository<Publisher,Long>
{
}
