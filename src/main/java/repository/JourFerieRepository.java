package repository;

import model.JourFerie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class JourFerieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupère tous les jours fériés
    public List<JourFerie> findAll() {
        TypedQuery<JourFerie> query = entityManager.createQuery(
            "SELECT j FROM JourFerie j", JourFerie.class
        );
        return query.getResultList();
    }

    // Vérifie si une date est un jour férié
    public boolean isJourFerie(LocalDate date) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(j) FROM JourFerie j WHERE j.date = :date", Long.class
        );
        query.setParameter("date", date);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }
}