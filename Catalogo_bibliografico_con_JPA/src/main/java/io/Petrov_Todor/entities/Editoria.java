package io.Petrov_Todor.entities;

import jakarta.persistence.*;

import java.util.Random;
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

    public Editoria(String title, int year_of_publication, int number_of_pages) {
        this.isbn_code = generateIsbnCode();
        this.title = title;
        this.year_of_publication = year_of_publication;
        this.number_of_pages = number_of_pages;
    }

    private String generateIsbnCode() {
        Random random = new Random();
        // Genera i numeri casuali per ciascun segmento del codice ISBN
        int part1 = random.nextInt(999); // Valore tra 0 e 998
        int part2 = random.nextInt(99); // Valore tra 0 e 998
        int part3 = random.nextInt(99999);  // Valore tra 0 e 98
        int part4 = random.nextInt(99);
        int part5 = random.nextInt(9);
        // Crea la stringa ISBN con il formato desiderato
        return String.format("%03d-%02d-%05d-%02d-%01d", part1, part2, part3, part4, part5);
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
