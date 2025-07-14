package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Statut_Exemplaire")
public class StatutExemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_status_exemplaire;

    @Column(nullable = false)
    private LocalDateTime date_ajout;

    @ManyToOne
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;

    @ManyToOne
    @JoinColumn(name = "id_statut", nullable = false)
    private Statut statut;

    // getters/setters
}