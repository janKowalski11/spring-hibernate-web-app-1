package com.springframework.springapp1.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long author_id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
    /*Gdy uzywamy Set'ow to TRZEBA implementowac metody
    * equals ,hashCode toString ,
    * bo setv uzywaja ich aby sprawdzic czy sie nie duplikuje
    * cos wewnatrz listy9*/

    public Author()
    {
    }

    public Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName, Set<Book> books)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public long getId()
    {
        return author_id;
    }

    public void setId(long id)
    {
        author_id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return author_id == author.author_id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(author_id);
    }

    @Override
    public String toString()
    {
        return "Author{" +
                "author_id=" + author_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }


}
