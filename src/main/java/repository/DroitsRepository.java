package repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DroitsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupère les droits (quota, nbr_prolongement, quota_reservation) pour un profil donné
    public Map<String, Object> getDroitsByProfil(int idProfil) {
        TypedQuery<Object[]> query = entityManager.createQuery(
            "SELECT cp.quota, cp.nbr_prolongement, cp.quota_reservation " +
            "FROM Profil p JOIN p.configurationProfil cp WHERE p.id_profil = :idProfil", Object[].class
        );
        query.setParameter("idProfil", idProfil);
        Object[] result = query.getSingleResult();
        Map<String, Object> droits = new HashMap<>();
        droits.put("quota", result[0]);
        droits.put("nbr_prolongement", result[1]);
        droits.put("quota_reservation", result[2]);
        return droits;
    }
}