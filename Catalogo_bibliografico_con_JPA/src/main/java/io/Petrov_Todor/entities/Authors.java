package io.Petrov_Todor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
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
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Authors() {
      
    }

    public Authors(String name, String surname, LocalDate date_of_birth) {
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
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
                '}';
    }
}
