package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reservation;

    @Column(nullable = false)
    private LocalDateTime date_reservation;

    @Column(nullable = false)
    private LocalDateTime date_reserver;

    @ManyToOne
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;

    @ManyToOne
    @JoinColumn(name = "id_adherent", nullable = false)
    private Adherent adherent;

    public Integer getId_reservation() { return id_reservation; }
    public void setId_reservation(Integer id_reservation) { this.id_reservation = id_reservation; }

    public LocalDateTime getDate_reservation() { return date_reservation; }
    public void setDate_reservation(LocalDateTime date_reservation) { this.date_reservation = date_reservation; }

    public LocalDateTime getDate_reserver() { return date_reserver; }
    public void setDate_reserver(LocalDateTime date_reserver) { this.date_reserver = date_reserver; }

    public Exemplaire getExemplaire() { return exemplaire; }
    public void setExemplaire(Exemplaire exemplaire) { this.exemplaire = exemplaire; }

    public Adherent getAdherent() { return adherent; }
    public void setAdherent(Adherent adherent) { this.adherent = adherent; }
}