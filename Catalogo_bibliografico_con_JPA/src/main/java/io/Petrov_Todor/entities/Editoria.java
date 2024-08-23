package io.Petrov_Todor.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Editoria {
    @Id
    @GeneratedValue
    private UUID id;
    private String isbn_code;
    private String title;
    private int year_of_publication;
    private int number_of_pages;

    public Editoria() {
    }

    public Editoria(String isbn_code, String title, int year_of_publication, int number_of_pages) {
        this.isbn_code = isbn_code;
        this.title = title;
        this.year_of_publication = year_of_publication;
        this.number_of_pages = number_of_pages;
    }

    public UUID getId() {
        return id;
    }


    public String getIsbn_code() {
        return isbn_code;
    }

    public void setIsbn_code(String isbn_code) {
        this.isbn_code = isbn_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    @Override
    public String toString() {
        return "Editoria{" +
                "id=" + id +
                ", isbn_code='" + isbn_code + '\'' +
                ", title='" + title + '\'' +
                ", year_of_publication=" + year_of_publication +
                ", number_of_pages=" + number_of_pages +
                '}';
    }
}
