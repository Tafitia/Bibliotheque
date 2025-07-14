package repository;

import model.TypePret;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TypePretRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupère tous les types de prêt
    public List<TypePret> findAll() {
        TypedQuery<TypePret> query = entityManager.createQuery(
            "SELECT t FROM TypePret t", TypePret.class
        );
        return query.getResultList();
    }

    // Récupère un type de prêt par son id
    public TypePret findById(int idTypePret) {
        return entityManager.find(TypePret.class, idTypePret);
    }

    // Récupère un type de prêt par son nom (insensible à la casse)
    public TypePret findByNom(String nom) {
        TypedQuery<TypePret> query = entityManager.createQuery(
            "SELECT t FROM TypePret t WHERE LOWER(t.nom) = LOWER(:nom)", TypePret.class
        );
        query.setParameter("nom", nom);
        List<TypePret> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}