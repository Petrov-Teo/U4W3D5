package io.Petrov_Todor;

import com.github.javafaker.Faker;
import io.Petrov_Todor.entities.Authors;
import io.Petrov_Todor.entities.Book;
import io.Petrov_Todor.entities.DAO.AuthorsDAO;
import io.Petrov_Todor.entities.DAO.EditoriaDAO;
import io.Petrov_Todor.entities.DAO.EditorialMaterialRentalDAO;
import io.Petrov_Todor.entities.DAO.UsersDAO;
import io.Petrov_Todor.entities.Magazine;
import io.Petrov_Todor.entities.Users;
import io.Petrov_Todor.enums.Periodicity;
import io.Petrov_Todor.enums.TypeBooks;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Catalogo bibliografico con JPA");

    public static void main(String[] args) {
        Faker fk = new Faker(Locale.ITALY);

        EntityManager em = emf.createEntityManager();
        AuthorsDAO ad = new AuthorsDAO(em);
        EditoriaDAO ed = new EditoriaDAO(em);
        EditorialMaterialRentalDAO erd = new EditorialMaterialRentalDAO(em);
        UsersDAO ud = new UsersDAO(em);

        // CREAZIONE USERS_______________________________________________________________________________________________________________________
        Users users1 = new Users(fk.name().firstName(), fk.name().lastName(), LocalDate.of(1952, 8, 2), fk.hashCode());
        System.out.println(users1);
//        ud.save(users1);

        // CREAZIONE AUTHORS_______________________________________________________________________________________________________________________
        Authors authors = new Authors(fk.name().firstName(), fk.name().lastName(), LocalDate.of(1854, 4, 1));
        System.out.println(authors);
//        ad.save(authors);

        // CREAZIONE BOOKS_______________________________________________________________________________________________________________________
        Authors authorFromDB = ad.findById("19605acf-b676-4610-8564-569e88d9dbff");
        System.out.println("L'elemento estratto è :" + authorFromDB);
        List<Authors> authorsList = Collections.singletonList(authorFromDB);
        Book book1 = new Book("784596130", fk.book().title(), 2004, 152, authorsList, TypeBooks.ENCYCLOPEDIA);
//        ed.save(book1);
        //________________________________________________________________________________________________________________________________________
        Authors authorFromDB2 = ad.findById("19605acf-b676-4610-8564-569e88d9dbff");
        System.out.println("L'elemento estratto è :" + authorFromDB);
        List<Authors> authorsList2 = Collections.singletonList(authorFromDB2);
        Book book2 = new Book("7848574547", fk.book().title(), 2024, 84, authorsList2, TypeBooks.SCIENCE);
//        ed.save(book2);
        //________________________________________________________________________________________________________________________________________
        Authors authorFromDB3 = ad.findById("c477bb0b-61cb-4570-b279-ddf9fed34697");
        System.out.println("L'elemento estratto è :" + authorFromDB);
        List<Authors> authorsList3 = Arrays.asList(authorFromDB, authorFromDB2);
        Book book3 = new Book("75481542", fk.book().title(), 1999, 233, authorsList3, TypeBooks.HORROR);
//        ed.save(book1);

        // CREAZIONE MAGAZINE____________________________________________________________________________________________________________________________
        Authors authorFromDbMagazine1 = ad.findById("b0227d56-6f05-4b89-98f9-17e3a0c10540");
        Authors authorFromDbMagazine2 = ad.findById("19605acf-b676-4610-8564-569e88d9dbff");
        Authors authorFromDbMagazine3 = ad.findById("19589056-cb87-4950-a010-9e86d82a216d");
        List<Authors> authorsList4 = Arrays.asList(authorFromDbMagazine1, authorFromDbMagazine2, authorFromDbMagazine3);
        Magazine magazine1 = new Magazine("7845126654", fk.book().title(), 2024, 25, authorsList4, Periodicity.WEEKLY);
        ed.save(magazine1);
        //________________________________________________________________________________________________________________________________________
        Authors authorFromDbMagazine4 = ad.findById("472d3c8f-c1f0-4e1b-accc-8365f9bdeb4e");
        List<Authors> authorsList5 = Collections.singletonList(authorFromDbMagazine4);
        Magazine magazine2 = new Magazine("89332514265", fk.book().title(), 2022, 56, authorsList4, Periodicity.MONTHLY);
        ed.save(magazine2);


    }

}
