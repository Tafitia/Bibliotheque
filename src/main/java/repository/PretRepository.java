package repository;

import model.Pret;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PretRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Insère un nouveau prêt
    public void insert(Pret pret) {
        entityManager.persist(pret);
    }

    // Récupère tous les prêts en cours pour un adhérent
    public List<Pret> findPretsEnCoursByAdherent(int idAdherent) {
        TypedQuery<Pret> query = entityManager.createQuery(
            "SELECT p FROM Pret p WHERE p.adherent.id_adherent = :idAdherent AND p.date_retour IS NULL",
            Pret.class
        );
        query.setParameter("idAdherent", idAdherent);
        return query.getResultList();
    }

    // Récupère tous les prêts d'un exemplaire
    public List<Pret> findByExemplaire(int idExemplaire) {
        TypedQuery<Pret> query = entityManager.createQuery(
            "SELECT p FROM Pret p WHERE p.exemplaire.id_exemplaire = :idExemplaire",
            Pret.class
        );
        query.setParameter("idExemplaire", idExemplaire);
        return query.getResultList();
    }

    // Récupère tous les prêts en retard
    public List<Pret> findPretsEnRetard(LocalDate today) {
        TypedQuery<Pret> query = entityManager.createQuery(
            "SELECT p FROM Pret p WHERE p.date_retour_prevue < :today AND p.date_retour IS NULL",
            Pret.class
        );
        query.setParameter("today", today);
        return query.getResultList();
    }

    // Met à jour un prêt
    public void update(Pret pret) {
        entityManager.merge(pret);
    }
}