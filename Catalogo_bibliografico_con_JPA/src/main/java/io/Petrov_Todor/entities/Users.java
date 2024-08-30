package io.Petrov_Todor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private LocalDate date_of_birth;
    @Column(unique = true, nullable = false)
    private int card_number;

    public Users() {
    }

    public Users(String name, String surname, String date_of_birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Random random = new Random();
        this.name = name;
        this.surname = surname;
        this.date_of_birth = LocalDate.parse(date_of_birth, formatter);
        this.card_number = random.nextInt(1000, 9999);
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

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", card_number=" + card_number +
                '}';
    }
}
