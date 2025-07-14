package repository;

import model.Note;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NoteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Insère une nouvelle note
    public void insert(Note note) {
        entityManager.persist(note);
    }

    // Vérifie si l'adhérent a déjà noté ce livre
    public boolean hasAlreadyNoted(int idAdherent, int idLivre) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(n) FROM Note n WHERE n.adherent.id_adherent = :idAdherent AND n.livre.id_livre = :idLivre",
            Long.class
        );
        query.setParameter("idAdherent", idAdherent);
        query.setParameter("idLivre", idLivre);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    // Récupère toutes les notes pour un livre
    public List<Note> findByLivre(int idLivre) {
        TypedQuery<Note> query = entityManager.createQuery(
            "SELECT n FROM Note n WHERE n.livre.id_livre = :idLivre",
            Note.class
        );
        query.setParameter("idLivre", idLivre);
        return query.getResultList();
    }

    // Supprime une note par son id
    public void delete(int idNote) {
        Note note = entityManager.find(Note.class, idNote);
        if (note != null) {
            entityManager.remove(note);
        }
    }
}