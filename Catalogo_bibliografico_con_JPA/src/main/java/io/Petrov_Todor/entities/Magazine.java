package io.Petrov_Todor.entities;

import io.Petrov_Todor.enums.Periodicity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Magazine extends Editoria {
    @ManyToMany()
    protected List<Authors> authors;
    @Enumerated(EnumType.STRING)
    protected Periodicity periodicity;

    public Magazine() {

    }

    public Magazine(String isbn_code, int year_of_publication, int number_of_pages, List<Authors> authors, Periodicity periodicity) {
        super(isbn_code, year_of_publication, number_of_pages);
        this.authors = authors;
        this.periodicity = periodicity;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodisity) {
        this.periodicity = periodisity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "authors=" + authors +
                ", periodicity=" + periodicity +
                '}';
    }
}
