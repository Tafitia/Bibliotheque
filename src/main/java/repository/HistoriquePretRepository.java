package repository;

import model.Pret;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HistoriquePretRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupère l'historique des prêts pour un adhérent (tous les prêts)
    public List<Pret> getHistoriqueByAdherent(int idAdherent) {
        TypedQuery<Pret> query = entityManager.createQuery(
            "SELECT p FROM Pret p WHERE p.adherent.id_adherent = :idAdherent ORDER BY p.date_pret DESC",
            Pret.class
        );
        query.setParameter("idAdherent", idAdherent);
        return query.getResultList();
    }
}