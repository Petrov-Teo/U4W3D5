package io.Petrov_Todor.entities.DAO;

import io.Petrov_Todor.entities.Editoria;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EditoriaDAO {
    private final EntityManager em;

    public EditoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Editoria editoria) {
        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Aggiungiamo l'oggetto al Persistence Context
        em.persist(editoria);
        // Fase quattro - concludiamo la transazione
        transaction.commit();
        System.out.println(editoria + "- E' stato salvato correttamente!");
    }

    public Editoria findById(String id) {
        Editoria find = em.find(Editoria.class, UUID.fromString(id));
        if (find == null) throw new NotFoundException(id);
        return find;
    }

    public void findByIdAndDelete(String id) {
        // fase zero - ricerchiamo l'oggetto
        Editoria find = this.findById(id);

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

    public List<Editoria> findAllEditoria() {
        TypedQuery<Editoria> query = em.createQuery("SELECT a FROM Editoria a", Editoria.class);
        return query.getResultList();
    }


    public List<String> findAllISBN(String uuid) {
        TypedQuery<String> query = em.createQuery("SELECT t.isbn_code FROM Book t", String.class);
        return query.getResultList();
    }

    public void finByISBN(String isbn) {
        System.out.println("------------------------------ SEARCH  BY ISBN -----------------------------------------");
        System.out.println("Valore di ricerca: " + isbn.toUpperCase());

        Query query = em.createQuery("SELECT a FROM Editoria a WHERE a.isbn_code = :isbn ");
        query.setParameter("isbn", isbn);
        throw new NotFoundException(isbn);
    }

    public void findByIsbnDelete(String isbn) {
        System.out.println("------------------------------ SEARCH AND DELETE BY ISBN -----------------------------------------");
        System.out.println("Valore di ricerca: " + isbn.toUpperCase());

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("DELETE FROM Editoria e WHERE e.isbn_code = :isbn");
        query.setParameter("isbn", isbn);

        int isbnDeleted = query.executeUpdate();

        if (isbnDeleted == 0) {
            transaction.rollback();
            throw new NotFoundException("Elemento con ISBN " + isbn + " non trovato.");
        }
        transaction.commit();
        System.out.println("Elemento eliminato con successo, numero di elementi eliminati: " + isbnDeleted);
    }
}



