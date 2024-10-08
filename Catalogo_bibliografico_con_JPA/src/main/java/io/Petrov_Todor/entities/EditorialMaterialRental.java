package io.Petrov_Todor.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
public class EditorialMaterialRental {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user_id;
    @ManyToOne
    @JoinColumn(name = "Book/Magazine_id")
    private Editoria editoria_id;
    private LocalDate loan_start_date;
    private LocalDate due_date;
    private LocalDate return_date;

    public EditorialMaterialRental() {
    }

    public EditorialMaterialRental(Users user_id, Editoria editoria_id, String loan_start_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.user_id = user_id;
        this.editoria_id = editoria_id;
        this.loan_start_date = LocalDate.parse(loan_start_date, formatter);
        this.due_date = this.loan_start_date.plusDays(30);

    }

    public UUID getId() {
        return id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Editoria getEditoria_id() {
        return editoria_id;
    }

    public LocalDate getLoan_start_date() {
        return loan_start_date;
    }

    public void setLoan_start_date(LocalDate loan_start_date) {
        this.loan_start_date = loan_start_date;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date() {
        this.due_date = due_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.return_date = LocalDate.parse(return_date, formatter);
    }

    @Override
    public String toString() {
        return "EditorialMaterialRental{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", editoria_id=" + editoria_id +
                ", loan_start_date=" + loan_start_date +
                ", due_date=" + due_date +
                ", return_date=" + return_date +
                '}';
    }
}
