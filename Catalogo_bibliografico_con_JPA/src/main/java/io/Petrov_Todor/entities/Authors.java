package io.Petrov_Todor.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Entity
public class Authors {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private LocalDate date_of_birth;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Book> books;

    public Authors() {

    }

    public Authors(String name, String surname, String date_of_birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.name = name;
        this.surname = surname;
        this.date_of_birth = LocalDate.parse(date_of_birth, formatter);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
//                ", books=" + books +
                '}';
    }
}
