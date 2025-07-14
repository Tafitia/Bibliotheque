package repository;

import model.Prolongement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ProlongementRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Compte le nombre de prolongements pour un prêt donné
    public int countProlongementsByPret(int idPret) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(p) FROM Prolongement p WHERE p.pret.id_pret = :idPret",
            Long.class
        );
        query.setParameter("idPret", idPret);
        Long count = query.getSingleResult();
        return count != null ? count.intValue() : 0;
    }

    // Insère un nouveau prolongement
    public void insertProlongement(Prolongement prolongement) {
        entityManager.persist(prolongement);
    }
}