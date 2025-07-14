package repository;

import model.Livre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LivreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Récupère tous les livres
    public List<Livre> findAll() {
        TypedQuery<Livre> query = entityManager.createQuery(
            "SELECT l FROM Livre l", Livre.class
        );
        return query.getResultList();
    }

    // Recherche de livres par titre (partiel, insensible à la casse)
    public List<Livre> findByTitre(String titre) {
        TypedQuery<Livre> query = entityManager.createQuery(
            "SELECT l FROM Livre l WHERE LOWER(l.titre) LIKE LOWER(:titre)", Livre.class
        );
        query.setParameter("titre", "%" + titre + "%");
        return query.getResultList();
    }

    // Recherche de livres par auteur (partiel, insensible à la casse)
    public List<Livre> findByAuteur(String auteur) {
        TypedQuery<Livre> query = entityManager.createQuery(
            "SELECT l FROM Livre l WHERE LOWER(l.auteur) LIKE LOWER(:auteur)", Livre.class
        );
        query.setParameter("auteur", "%" + auteur + "%");
        return query.getResultList();
    }

    // Recherche de livre par ISBN
    public Livre findByIsbn(String isbn) {
        TypedQuery<Livre> query = entityManager.createQuery(
            "SELECT l FROM Livre l WHERE l.isbn = :isbn", Livre.class
        );
        query.setParameter("isbn", isbn);
        List<Livre> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}