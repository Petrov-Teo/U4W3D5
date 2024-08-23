package io.Petrov_Todor.entities;

import io.Petrov_Todor.enums.Periodicity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Magazine extends Editoria {
    @Enumerated(EnumType.STRING)
    protected Periodicity periodicity;

    public Magazine() {

    }

    public Magazine(String isbn_code, String title, int year_of_publication, int number_of_pages, Periodicity periodicity) {
        super(isbn_code, title, year_of_publication, number_of_pages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                '}';
    }
}
