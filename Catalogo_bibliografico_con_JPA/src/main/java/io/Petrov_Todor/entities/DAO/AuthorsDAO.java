package io.Petrov_Todor.entities.DAO;

import io.Petrov_Todor.entities.Authors;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class AuthorsDAO {
    private final EntityManager em;

    public AuthorsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Authors authors) {
        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Aggiungiamo l'oggetto al Persistence Context
        em.persist(authors);
        // Fase quattro - concludiamo la transazione
        transaction.commit();
        System.out.println(authors + "- E' stato salvato correttamente!");
    }

    public Authors findById(String id) {
        Authors find = em.find(Authors.class, UUID.fromString(id));
        if (find == null) throw new NotFoundException(id);
        return find;
    }

    public void findByIdAndDelete(String id) {
        // fase zero - ricerchiamo l'oggetto
        Authors find = this.findById(id);

        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Rimuoviamo l'oggetto al Persistence Context

        em.remove(find);
        // Fase quattro - concludiamo la transazione
        transaction.commit();

        System.out.println(id + " - E' stato eliminato!");


    }

    public List<Authors> filtersAuthorsByName(String name) {
        System.out.println("------------------------------ SEARCH BY AUTHORS -----------------------------------------");
        System.out.println("Valore di ricerca: " + name.toUpperCase());
        if (!name.trim().isEmpty()) {
            TypedQuery<Authors> query = em.createQuery("SELECT a FROM Authors a WHERE LOWER (a.name) LIKE LOWER(:n) OR LOWER (a.surname) LIKE LOWER(:n)", Authors.class);
            query.setParameter("n", "%" + name.toLowerCase() + "%");
            List<Authors> results = query.getResultList();
            if (results.isEmpty()) {
                System.out.println("Nessun Autore trovato per il parametro di ricerca:" + name);
            }
            return results;
        } else {
            throw new NotFoundException("Nome non valido:" + name);
        }

    }
}








