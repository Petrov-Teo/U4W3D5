package io.Petrov_Todor;

import com.github.javafaker.Faker;
import io.Petrov_Todor.entities.*;
import io.Petrov_Todor.entities.DAO.AuthorsDAO;
import io.Petrov_Todor.entities.DAO.EditoriaDAO;
import io.Petrov_Todor.entities.DAO.EditorialMaterialRentalDAO;
import io.Petrov_Todor.entities.DAO.UsersDAO;
import io.Petrov_Todor.enums.Periodicity;
import io.Petrov_Todor.enums.TypeBooks;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

        // CREAZIONE USERS _______________________________________________________________________________________________________________________

        Users users1 = new Users(fk.name().firstName(), fk.name().lastName(), "01/05/2002");
        Users users2 = new Users(fk.name().firstName(), fk.name().lastName(), "04/01/1985");
        Users users3 = new Users(fk.name().firstName(), fk.name().lastName(), "17/12/1925");
        Users users4 = new Users(fk.name().firstName(), fk.name().lastName(), "26/11/1988");
        Users users5 = new Users(fk.name().firstName(), fk.name().lastName(), "05/10/1963");
        Users users6 = new Users(fk.name().firstName(), fk.name().lastName(), "19/03/1995");
        Users users7 = new Users(fk.name().firstName(), fk.name().lastName(), "15/07/1991");
        Users users8 = new Users(fk.name().firstName(), fk.name().lastName(), "21/10/1963");
        Users users9 = new Users(fk.name().firstName(), fk.name().lastName(), "28/08/1961");
        Users users10 = new Users(fk.name().firstName(), fk.name().lastName(), "24/12/1986");

        // SALVATAGGIO USERS _______________________________________________________________________________________________________________________

//        ud.save(users1);
//        ud.save(users2);
//        ud.save(users3);
//        ud.save(users4);
//        ud.save(users5);
//        ud.save(users6);
//        ud.save(users7);
//        ud.save(users8);
//        ud.save(users9);
//        ud.save(users10);

        // CREAZIONE AUTHORS _______________________________________________________________________________________________________________________
        Authors authors1 = new Authors(fk.name().firstName(), fk.name().lastName(), "07/09/1986");
        Authors authors2 = new Authors(fk.name().firstName(), fk.name().lastName(), "08/12/1948");
        Authors authors3 = new Authors(fk.name().firstName(), fk.name().lastName(), "07/11/1784");
        Authors authors4 = new Authors(fk.name().firstName(), fk.name().lastName(), "01/02/2002");
        Authors authors5 = new Authors(fk.name().firstName(), fk.name().lastName(), "04/01/1984");
        Authors authors6 = new Authors(fk.name().firstName(), fk.name().lastName(), "15/10/1902");
        Authors authors7 = new Authors(fk.name().firstName(), fk.name().lastName(), "25/03/1985");
        Authors authors8 = new Authors(fk.name().firstName(), fk.name().lastName(), "29/12/1945");
        Authors authors9 = new Authors(fk.name().firstName(), fk.name().lastName(), "01/09/1991");
        Authors authors10 = new Authors(fk.name().firstName(), fk.name().lastName(), "31/07/1965");

        // SALVATAGGIO AUTHORS _______________________________________________________________________________________________________________________

//        ad.save(authors1);
//        ad.save(authors2);
//        ad.save(authors3);
//        ad.save(authors4);
//        ad.save(authors5);
//        ad.save(authors6);
//        ad.save(authors7);
//        ad.save(authors8);
//        ad.save(authors9);
//        ad.save(authors10);

        // CREAZIONE BOOKS _______________________________________________________________________________________________________________________
        Authors authorFromDB1 = ad.findById("b50b5373-e47c-4b55-90d6-f2ccc13f78c4");
        Authors authorFromDB2 = ad.findById("7a4a5158-0311-4a19-8fda-c29880dc4289");
        Authors authorFromDB3 = ad.findById("e7b5a361-1588-4e87-af26-3615c4b0fc5b");
        Authors authorFromDB4 = ad.findById("ff12000b-fb03-4cf2-8035-e6809dbe0cd2");
        Authors authorFromDB5 = ad.findById("bcbe5bc8-ea46-453a-9a57-08b426dcbce8");
        Authors authorFromDB6 = ad.findById("5457ce1d-f02e-44d2-b3c2-95e612063f38");
        Authors authorFromDB7 = ad.findById("ed4b6fab-a3f3-4b3b-84e8-1c55e0bbd1c3");
        Authors authorFromDB8 = ad.findById("ee383a79-107f-4ea0-a85c-2fb724a2bffb");
        Authors authorFromDB9 = ad.findById("317dcca3-9c79-4135-91d5-7ee3a2ecd15f");
        Authors authorFromDB10 = ad.findById("8949c946-b03c-433c-af26-57c14ba5e430");


        List<Authors> authorsList1 = Collections.singletonList(authorFromDB1);
        Book book1 = new Book(fk.book().title(), 2004, 152, authorsList1, TypeBooks.ENCYCLOPEDIA);
        List<Authors> authorsList2 = Collections.singletonList(authorFromDB2);
        Book book2 = new Book(fk.book().title(), 1895, 452, authorsList2, TypeBooks.SCIENCE);
        List<Authors> authorsList3 = Collections.singletonList(authorFromDB3);
        Book book3 = new Book(fk.book().title(), 2016, 205, authorsList3, TypeBooks.AUTOBIOGRAPHY);
        List<Authors> authorsList4 = Collections.singletonList(authorFromDB4);
        Book book4 = new Book(fk.book().title(), 1918, 144, authorsList4, TypeBooks.BUSSNESS);
        List<Authors> authorsList5 = Collections.singletonList(authorFromDB5);
        Book book5 = new Book(fk.book().title(), 1963, 152, authorsList5, TypeBooks.HORROR);
        List<Authors> authorsList6 = Collections.singletonList(authorFromDB6);
        Book book6 = new Book(fk.book().title(), 2024, 436, authorsList6, TypeBooks.CLASSIC);
        List<Authors> authorsList7 = Collections.singletonList(authorFromDB7);
        Book book7 = new Book(fk.book().title(), 2022, 85, authorsList7, TypeBooks.TRUE_CRIME);
        List<Authors> authorsList8 = Collections.singletonList(authorFromDB8);
        Book book8 = new Book(fk.book().title(), 2002, 55, authorsList8, TypeBooks.CHILDREN_BOOKS);
        List<Authors> authorsList9 = Collections.singletonList(authorFromDB9);
        Book book9 = new Book(fk.book().title(), 1845, 85, authorsList9, TypeBooks.DRAMA);
        List<Authors> authorsList10 = Collections.singletonList(authorFromDB10);
        Book book10 = new Book(fk.book().title(), 2022, 85, authorsList10, TypeBooks.MYSTERY);

        //BOOKS CON PIÙ AUTORI_______________________________________________________________________________________________________________________________

        List<Authors> authorsList11 = Arrays.asList(authorFromDB4, authorFromDB5);
        List<Authors> authorsList12 = Arrays.asList(authorFromDB2, authorFromDB10, authorFromDB5);
        List<Authors> authorsList13 = Arrays.asList(authorFromDB4, authorFromDB9, authorFromDB3);

        Book bookWithMoreAuthors1 = new Book(fk.book().title(), 1999, 233, authorsList11, TypeBooks.GUIDE);
        Book bookWithMoreAuthors2 = new Book(fk.book().title(), 1999, 233, authorsList12, TypeBooks.MYSTERY);
        Book bookWithMoreAuthors3 = new Book(fk.book().title(), 1999, 233, authorsList13, TypeBooks.FANTASY);


        // SALVATAGGIO BOOKS _______________________________________________________________________________________________________________________

//        ed.save(book1);
//        ed.save(book2);
//        ed.save(book3);
//        ed.save(book4);
//        ed.save(book5);
//        ed.save(book6);
//        ed.save(book7);
//        ed.save(book8);
//        ed.save(book9);
//        ed.save(book10);
//        ed.save(bookWithMoreAuthors1);
//        ed.save(bookWithMoreAuthors2);
//        ed.save(bookWithMoreAuthors3);


        // CREAZIONE MAGAZINE____________________________________________________________________________________________________________________________

        Magazine magazine1 = new Magazine(fk.book().title(), 2024, 15, Periodicity.WEEKLY);
        Magazine magazine2 = new Magazine(fk.book().title(), 2022, 43, Periodicity.MONTHLY);
        Magazine magazine3 = new Magazine(fk.book().title(), 2018, 262, Periodicity.SEMI_ANNUAL);

        // SALVATAGGIO BOOKS _______________________________________________________________________________________________________________________
//
//        ed.save(magazine1);
//        ed.save(magazine2);
//        ed.save(magazine3);


        // CREAZIONE EDITORIA MATERIAL RENTAL ____________________________________________________________________________________________________________________________
        Users cliente1 = ud.findById("b9734921-6aef-4cba-bb3b-012853f8beee");
        Editoria bookRentals = ed.findById("ba4fda61-8462-4f76-86df-5d785bc8ae00"); //BOOK or MAGAZINE


        EditorialMaterialRental rental1 = new EditorialMaterialRental(cliente1, bookRentals, "25/03/2024");


//        erd.save(rental1);


        // RESTITUZIONE MATERIAL RENTAL ________________________________________________________________________________________________________________________

        EditorialMaterialRental rental1FromDb = erd.findById("2b36fb7b-a42a-4eae-b40e-500b5824ced4");
        rental1FromDb.setReturn_date("22/04/2024");

//        erd.save(rental1FromDb);

//        Users cliente2 = ud.findById("18a82173-fb23-4503-b327-42fecaebb1cb"); // user
//        Editoria bookrental2 = ed.findById("32099958-b5ad-40c0-b5b7-8097c072e3b6"); //BOOK or MAGAZINE
//        EditorialMaterialRental rental2 = new EditorialMaterialRental(cliente2, bookrental2, LocalDate.of(2022, 12, 4), null, LocalDate.of(2022, 12, 9));
//        rental1.setDue_date();
//        System.out.println(rental2);
//        erd.save(rental2);

//        Editoria bookfromdb = ed.findById("32099958-b5ad-40c0-b5b7-8097c072e3b6");
//        System.out.println(bookfromdb);
//
//        System.out.println("_____________________________All ");
//        ed.findAllEditoria().forEach(System.out::println);

//      SEARCH BY AUTHOR
//        ad.filtersAuthorsByName("miriana").forEach(System.out::println);
//
////        DELETET BOOK FROM ISBN
//        ed.findByIsbnDelete("12345678");
//        System.out.println(ed.findAllEditoria());

//        FIND BY ISBN
//        ed.finByISBN("8574965123");
        System.out.println("hello word");

    }


}
