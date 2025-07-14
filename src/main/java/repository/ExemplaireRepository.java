package repository;

import model.Exemplaire;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ExemplaireRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupérer tous les exemplaires
    public List<Exemplaire> findAll() {
        TypedQuery<Exemplaire> query = entityManager.createQuery(
            "SELECT e FROM Exemplaire e", Exemplaire.class
        );
        return query.getResultList();
    }

    // Récupérer tous les exemplaires disponibles (statut = 'Disponible')
    public List<Exemplaire> findAllDisponibles() {
        TypedQuery<Exemplaire> query = entityManager.createQuery(
            "SELECT e FROM Exemplaire e " +
            "JOIN StatutExemplaire se ON se.exemplaire.id_exemplaire = e.id_exemplaire " +
            "JOIN Statut s ON se.statut.id_statut = s.id_statut " +
            "WHERE s.nom = 'Disponible' AND se.date_ajout = (" +
            "   SELECT MAX(se2.date_ajout) FROM StatutExemplaire se2 WHERE se2.exemplaire.id_exemplaire = e.id_exemplaire" +
            ")",
            Exemplaire.class
        );
        return query.getResultList();
    }

    // Récupérer tous les exemplaires non disponibles (statut != 'Disponible')
    public List<Exemplaire> findAllNonDisponibles() {
        TypedQuery<Exemplaire> query = entityManager.createQuery(
            "SELECT e FROM Exemplaire e " +
            "JOIN StatutExemplaire se ON se.exemplaire.id_exemplaire = e.id_exemplaire " +
            "JOIN Statut s ON se.statut.id_statut = s.id_statut " +
            "WHERE s.nom <> 'Disponible' AND se.date_ajout = (" +
            "   SELECT MAX(se2.date_ajout) FROM StatutExemplaire se2 WHERE se2.exemplaire.id_exemplaire = e.id_exemplaire" +
            ")",
            Exemplaire.class
        );
        return query.getResultList();
    }

    // Récupérer le dernier statut d'un exemplaire (id_statut)
    public Integer getLastStatutForExemplaire(int idExemplaire) {
        TypedQuery<Integer> query = entityManager.createQuery(
            "SELECT se.statut.id_statut FROM StatutExemplaire se " +
            "WHERE se.exemplaire.id_exemplaire = :idExemplaire " +
            "ORDER BY se.date_ajout DESC", Integer.class
        );
        query.setParameter("idExemplaire", idExemplaire);
        List<Integer> result = query.setMaxResults(1).getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // Récupérer le nom du dernier statut d'un exemplaire
    public String getLastStatutNameForExemplaire(int idExemplaire) {
        TypedQuery<String> query = entityManager.createQuery(
            "SELECT se.statut.nom FROM StatutExemplaire se " +
            "WHERE se.exemplaire.id_exemplaire = :idExemplaire " +
            "ORDER BY se.date_ajout DESC", String.class
        );
        query.setParameter("idExemplaire", idExemplaire);
        List<String> result = query.setMaxResults(1).getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // Obtenir l'id_statut à partir du nom
    public Integer getStatutIdByNom(String nomStatut) {
        TypedQuery<Integer> query = entityManager.createQuery(
            "SELECT s.id_statut FROM Statut s WHERE LOWER(s.nom) = LOWER(:nomStatut)", Integer.class
        );
        query.setParameter("nomStatut", nomStatut);
        List<Integer> result = query.setMaxResults(1).getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // Vérifie si la catégorie de prêt de l'exemplaire est 'Non Emportable'
    public boolean isLectureSurPlaceAutorisee(int idExemplaire) {
        TypedQuery<String> query = entityManager.createQuery(
            "SELECT l.categoriePret.nom FROM Exemplaire e " +
            "JOIN e.livre l WHERE e.id_exemplaire = :idExemplaire", String.class
        );
        query.setParameter("idExemplaire", idExemplaire);
        List<String> result = query.getResultList();
        return !result.isEmpty() && "Non Emportable".equalsIgnoreCase(result.get(0));
    }

    // Récupérer les exemplaires non disponibles pour une date donnée
    public List<Exemplaire> getExemplairesNonDisponiblesPourDate(LocalDate date) {
        TypedQuery<Exemplaire> query = entityManager.createQuery(
            "SELECT e FROM Exemplaire e WHERE EXISTS (" +
            "   SELECT p FROM Pret p WHERE p.exemplaire.id_exemplaire = e.id_exemplaire " +
            "   AND :date BETWEEN p.date_pret AND p.date_retour" +
            ")",
            Exemplaire.class
        );
        query.setParameter("date", date);
        return query.getResultList();
    }

    // Récupérer les exemplaires disponibles pour une période
    public List<Exemplaire> getExemplairesDisponiblesPourPeriode(LocalDate debut, LocalDate fin) {
        TypedQuery<Exemplaire> query = entityManager.createQuery(
            "SELECT e FROM Exemplaire e WHERE NOT EXISTS (" +
            "   SELECT p FROM Pret p WHERE p.exemplaire.id_exemplaire = e.id_exemplaire " +
            "   AND (p.date_pret, p.date_retour) OVERLAPS (:debut, :fin)" +
            ")",
            Exemplaire.class
        );
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        return query.getResultList();
    }
}