package repository;

import model.Profil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProfilRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupère tous les profils
    public List<Profil> findAll() {
        TypedQuery<Profil> query = entityManager.createQuery(
            "SELECT p FROM Profil p", Profil.class
        );
        return query.getResultList();
    }

    // Récupère un profil par son id
    public Profil findById(int idProfil) {
        return entityManager.find(Profil.class, idProfil);
    }

    // Récupère un profil par son nom
    public Profil findByNom(String nom) {
        TypedQuery<Profil> query = entityManager.createQuery(
            "SELECT p FROM Profil p WHERE LOWER(p.nom) = LOWER(:nom)", Profil.class
        );
        query.setParameter("nom", nom);
        List<Profil> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}