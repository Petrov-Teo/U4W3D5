package io.Petrov_Todor.entities;

import io.Petrov_Todor.enums.TypeBooks;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class Book extends Editoria {
    @ManyToMany()
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    protected List<Authors> authors;
    @Enumerated(EnumType.STRING)
    protected TypeBooks type_book;

    public Book() {
        super();
    }

    public Book(String isbn_code, String title, int year_of_publication, int number_of_pages, List<Authors> authors, TypeBooks type_book) {
        super(isbn_code, title, year_of_publication, number_of_pages);
        this.authors = authors;
        this.type_book = type_book;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public TypeBooks getType_book() {
        return type_book;
    }

    public void setType_book(TypeBooks type_book) {
        this.type_book = type_book;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", type_book=" + type_book +
                '}';
    }
}
