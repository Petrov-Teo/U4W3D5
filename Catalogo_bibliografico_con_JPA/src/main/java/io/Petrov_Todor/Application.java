package io.Petrov_Todor;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Catalogo bibliografico con JPA");

    public static void main(String[] args) {
        Faker fk = new Faker(Locale.ITALY);
        EntityManager em = emf.createEntityManager();

        EntityManager em = emf.createEntityManager();
    }
}
