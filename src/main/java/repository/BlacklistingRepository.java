package repository;

import model.Blacklisting;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BlacklistingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Insère un nouvel enregistrement de blacklisting
    public void insert(Blacklisting blacklisting) {
        entityManager.persist(blacklisting);
    }

    // Vérifie si un adhérent est blacklisté à une date donnée
    public boolean isBlacklisted(int idAdherent, LocalDateTime now) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(b) FROM Blacklisting b WHERE b.adherent.id_adherent = :idAdherent AND :now BETWEEN b.date_debut AND b.date_fin",
            Long.class
        );
        query.setParameter("idAdherent", idAdherent);
        query.setParameter("now", now);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    // Récupère tous les blacklistings actifs à une date donnée
    public List<Blacklisting> getActiveBlacklistings(LocalDateTime now) {
        TypedQuery<Blacklisting> query = entityManager.createQuery(
            "SELECT b FROM Blacklisting b WHERE :now BETWEEN b.date_debut AND b.date_fin",
            Blacklisting.class
        );
        query.setParameter("now", now);
        return query.getResultList();
    }
}