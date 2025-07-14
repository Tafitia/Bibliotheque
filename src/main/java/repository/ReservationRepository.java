package repository;

import model.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ReservationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Compte les réservations en cours pour un adhérent
    public int countReservationsEnCoursByAdherent(int idAdherent) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(r) FROM Reservation r WHERE r.adherent.id_adherent = :idAdherent AND r.date_reserver > :now",
            Long.class
        );
        query.setParameter("idAdherent", idAdherent);
        query.setParameter("now", LocalDateTime.now());
        Long count = query.getSingleResult();
        return count != null ? count.intValue() : 0;
    }

    // Insère une nouvelle réservation
    public void insertReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

    // Vérifie si un exemplaire est réservable (catégorie de prêt = 'Emportable')
    public boolean isExemplaireReservable(int idExemplaire) {
        TypedQuery<String> query = entityManager.createQuery(
            "SELECT l.categoriePret.nom FROM Exemplaire e JOIN e.livre l WHERE e.id_exemplaire = :idExemplaire",
            String.class
        );
        query.setParameter("idExemplaire", idExemplaire);
        List<String> result = query.getResultList();
        return !result.isEmpty() && "Emportable".equalsIgnoreCase(result.get(0));
    }

    // Récupère toutes les réservations d'un adhérent
    public List<Reservation> findByAdherent(int idAdherent) {
        TypedQuery<Reservation> query = entityManager.createQuery(
            "SELECT r FROM Reservation r WHERE r.adherent.id_adherent = :idAdherent",
            Reservation.class
        );
        query.setParameter("idAdherent", idAdherent);
        return query.getResultList();
    }

    // Récupère toutes les réservations d'un exemplaire
    public List<Reservation> findByExemplaire(int idExemplaire) {
        TypedQuery<Reservation> query = entityManager.createQuery(
            "SELECT r FROM Reservation r WHERE r.exemplaire.id_exemplaire = :idExemplaire",
            Reservation.class
        );
        query.setParameter("idExemplaire", idExemplaire);
        return query.getResultList();
    }
}