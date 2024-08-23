package io.Petrov_Todor.entities.DAO;

import io.Petrov_Todor.entities.Editoria;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

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

    public Editoria findByISBN(String ISBN) {
        // Usa una query SQL nativa per cercare per ISBN
        String sql = "SELECT * FROM Editoria WHERE isbn_code = :isbnCode";
        Query query = em.createNativeQuery(sql, Editoria.class);
        query.setParameter("isbnCode", ISBN);

        try {
            return (Editoria) query.getSingleResult();
        } catch (NoResultException e) {
            throw new NotFoundException("Editoria with ISBN " + ISBN + " not found.");
        }
    }
}
