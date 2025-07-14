package repository;

import model.Penalite;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PenaliteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Insère une nouvelle pénalité
    public void insertPenalite(Penalite penalite) {
        entityManager.persist(penalite);
    }

    // Compte les pénalités de type "Retard" récentes pour un adhérent
    public int countRetardsRecents(int idAdherent, LocalDate sinceDate) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(p) FROM Penalite p WHERE p.adherent.id_adherent = :idAdherent " +
            "AND p.typePenalite.nom = 'Retard' AND p.date_penalite >= :sinceDate",
            Long.class
        );
        query.setParameter("idAdherent", idAdherent);
        query.setParameter("sinceDate", sinceDate.atStartOfDay());
        Long count = query.getSingleResult();
        return count != null ? count.intValue() : 0;
    }

    // Récupère toutes les pénalités d'un adhérent
    public List<Penalite> findByAdherent(int idAdherent) {
        TypedQuery<Penalite> query = entityManager.createQuery(
            "SELECT p FROM Penalite p WHERE p.adherent.id_adherent = :idAdherent",
            Penalite.class
        );
        query.setParameter("idAdherent", idAdherent);
        return query.getResultList();
    }
}