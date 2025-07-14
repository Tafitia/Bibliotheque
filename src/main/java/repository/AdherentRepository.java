package repository;

import model.Adherent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AdherentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupère tous les noms des adhérents
    public List<String> findAllNames() {
        TypedQuery<String> query = entityManager.createQuery(
            "SELECT a.nom FROM Adherent a", String.class
        );
        return query.getResultList();
    }

    // Insère un nouvel adhérent
    public void insert(Adherent adherent) {
        entityManager.persist(adherent);
    }

    // Authentifie un adhérent par identifiant et mot de passe
    public Adherent getByIdentifiantAndPassword(String identifiant, String password) {
        TypedQuery<Adherent> query = entityManager.createQuery(
            "SELECT a FROM Adherent a WHERE a.identifiant = :identifiant AND a.password = :password", Adherent.class
        );
        query.setParameter("identifiant", identifiant);
        query.setParameter("password", password);
        List<Adherent> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // Récupère un adhérent par son identifiant
    public Adherent getByIdentifiant(String identifiant) {
        TypedQuery<Adherent> query = entityManager.createQuery(
            "SELECT a FROM Adherent a WHERE a.identifiant = :identifiant", Adherent.class
        );
        query.setParameter("identifiant", identifiant);
        List<Adherent> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // Récupère l'id du profil d'un adhérent
    public Integer getProfilIdByAdherent(int idAdherent) {
        TypedQuery<Integer> query = entityManager.createQuery(
            "SELECT a.profil.id_profil FROM Adherent a WHERE a.id_adherent = :idAdherent", Integer.class
        );
        query.setParameter("idAdherent", idAdherent);
        List<Integer> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // Récupère tous les identifiants et noms des adhérents
    public List<Object[]> findAllIdentifiantsEtNoms() {
        TypedQuery<Object[]> query = entityManager.createQuery(
            "SELECT a.identifiant, a.nom FROM Adherent a", Object[].class
        );
        return query.getResultList();
    }

    // Récupère un objet Adherent complet par son id
    public Adherent findById(int idAdherent) {
        return entityManager.find(Adherent.class, idAdherent);
    }
}