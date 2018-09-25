package com.springframework.springapp1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long book_id;

    private String title;
    private String isbn;

    @OneToOne
    private Publisher publisher;

    /*
    Join table tworzy tabele relacyjna bez daanych
    name - nazwa tabeli
     joinColumns - dodaj kolumne o nazwie
     inverse join column- dodaj kolumne ktora bedzie miala relacje z join column*/
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",referencedColumnName = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    public Book()
    {
    }

    public Book(String title, String isbn, Publisher publisher)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(String title, String isbn, Publisher publisher, Set<Author> authors)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public long getId()
    {
        return book_id;
    }

    public void setId(long id)
    {
        book_id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public Publisher getPublisher()
    {
        return publisher;
    }

    public void setPublisher(Publisher publisher)
    {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(Set<Author> authors)
    {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id;
    }
    /*Implementuje tylko equals dla zmiennej id
    * bo on jest unikatowy reszta pol nie
    * np 2 ksiazki o tym  samym tytule !!!*/

    @Override
    public int hashCode()
    {
        return Objects.hash(book_id);
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
}
