package io.Petrov_Todor.entities.DAO;

import io.Petrov_Todor.entities.EditorialMaterialRental;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EditorialMaterialRentalDAO {
    private final EntityManager em;

    public EditorialMaterialRentalDAO(EntityManager em) {
        this.em = em;
    }


    public void save(EditorialMaterialRental rental) {
        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Aggiungiamo l'oggetto al Persistence Context
        em.persist(rental);
        // Fase quattro - concludiamo la transazione
        transaction.commit();
        System.out.println(rental + "- E' stato salvato correttamente!");
    }

    public EditorialMaterialRental findById(String id) {
        EditorialMaterialRental find = em.find(EditorialMaterialRental.class, UUID.fromString(id));
        if (find == null) throw new NotFoundException(id);
        return find;
    }

    public void findByIdAndDelete(String id) {
        // fase zero - ricerchiamo l'oggetto
        EditorialMaterialRental find = this.findById(id);

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
}
