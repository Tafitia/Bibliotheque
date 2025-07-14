package repository;

import model.Inscription;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public class InscriptionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Vérifie si une inscription existe pour la période (chevauchement)
    public boolean hasInscriptionForPeriod(int idAdherent, Timestamp debut, Timestamp fin) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(i) FROM Inscription i WHERE i.adherent.id_adherent = :idAdherent AND (i.date_debut, i.date_fin) OVERLAPS (:debut, :fin)",
            Long.class
        );
        query.setParameter("idAdherent", idAdherent);
        query.setParameter("debut", debut.toLocalDateTime());
        query.setParameter("fin", fin.toLocalDateTime());
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    // Insère une nouvelle inscription
    public void insert(Inscription inscription) {
        entityManager.persist(inscription);
    }

    // Vérifie si l'adhérent est actif à la date du jour
    public boolean isActif(int idAdherent, LocalDate now) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(i) FROM Inscription i WHERE i.adherent.id_adherent = :idAdherent AND :now BETWEEN i.date_debut AND i.date_fin",
            Long.class
        );
        query.setParameter("idAdherent", idAdherent);
        query.setParameter("now", now);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    // Liste tous les adhérents (id uniquement)
    public List<Integer> getAllAdherentIds() {
        TypedQuery<Integer> query = entityManager.createQuery(
            "SELECT i.adherent.id_adherent FROM Inscription i",
            Integer.class
        );
        return query.getResultList();
    }
}