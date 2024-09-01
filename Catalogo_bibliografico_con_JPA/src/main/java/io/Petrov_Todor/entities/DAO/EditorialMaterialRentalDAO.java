package io.Petrov_Todor.entities.DAO;

import io.Petrov_Todor.entities.EditorialMaterialRental;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class EditorialMaterialRentalDAO {
    private final EntityManager em;

    public EditorialMaterialRentalDAO(EntityManager em) {
        this.em = em;
    }


    public void save(EditorialMaterialRental rental) {
        try {

            UUID bookId = rental.getEditoria_id().getId();


            TypedQuery<EditorialMaterialRental> query = em.createQuery(
                    "SELECT r FROM EditorialMaterialRental r WHERE r.editoria_id.id = :bookId ORDER BY r.due_date DESC",
                    EditorialMaterialRental.class
            );
            query.setParameter("bookId", bookId);
            query.setMaxResults(1);

            System.out.println("__________________________________________________");
            EditorialMaterialRental lastRental = query.getSingleResult();


            // Verifica se il materiale editoriale è ancora in prestito
            if (lastRental.getReturn_date() == null) {
                System.out.println("Ups! Il libro " + rental.getEditoria_id().getTitle() + " è stato già noleggiato, sarà disponibile dal: "
                        + lastRental.getDue_date().plusDays(1)
                        + " oppure se vuoi puoi prenotare una notifica e ti avviseremo quando il libro è disponibile!");
                return;
            }

        } catch (NoResultException e) {

            System.out.println("Nessun noleggio precedente trovato, procedo con il salvataggio.");
        }

        try {
            // Fase uno - chiediamo a Manager di fornirci una transazione
            EntityTransaction transaction = em.getTransaction();
            System.out.println("Rental return_date: " + rental.getReturn_date());

            // Fase due - Eseguiamo la transazione
            transaction.begin();

            // Fase tre - Aggiungiamo l'oggetto al Persistence Context
            em.persist(rental);

            // Fase quattro - concludiamo la transazione
            transaction.commit();
            System.out.println(rental + " - È stato salvato correttamente!");
        } catch (Exception e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
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

    public List<EditorialMaterialRental> findActiveRentalsByCardNumber(int cardNumber) {
        try {

            TypedQuery<EditorialMaterialRental> query = em.createQuery(
                    "SELECT r FROM EditorialMaterialRental r WHERE r.user_id.card_number = :cardNumber AND r.return_date IS NULL",
                    EditorialMaterialRental.class
            );


            query.setParameter("cardNumber", cardNumber);

            System.out.println("************************************************************");
            System.out.println("PER LA CARD N° " + " " + cardNumber + " " + "La lista del materiale attualmente noleggiato è : ");
            System.out.println("************************************************************");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca dei noleggi attivi per il numero di tessera: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<EditorialMaterialRental> findAllActivRentalMaterials() {
        try {
            TypedQuery<EditorialMaterialRental> query = em.createQuery(
                    "SELECT r FROM EditorialMaterialRental r WHERE r.return_date IS NULL", EditorialMaterialRental.class);

            List<EditorialMaterialRental> rentals = query.getResultList();
            int totBooksRent = rentals.size();

            System.out.println("************************************************************");
            System.out.println("La lista del materiale attualmente noleggiato è : ");
            for (EditorialMaterialRental rental : rentals) {
                System.out.println(rental);
            }
            System.out.println("totale libri attualmente noleggiati:" + totBooksRent);
            System.out.println("************************************************************");

            return rentals;

        } catch (Exception e) {
            System.out.println("Errore durante la ricerca dei noleggi attivi" + e.getMessage());
            return Collections.emptyList();
        }

    }
}


