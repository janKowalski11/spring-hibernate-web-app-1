package com.springframework.springapp1.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
Author: BeGieU
Date: 25.09.2018
*/
@Entity
public class Publisher
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long publisher_id;
    String name;
    String addres;

    public Long getPublisher_id()
    {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id)
    {
        this.publisher_id = publisher_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddres()
    {
        return addres;
    }

    public void setAddres(String addres)
    {
        this.addres = addres;
    }
}
