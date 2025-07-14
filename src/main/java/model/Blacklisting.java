package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Blacklisting")
public class Blacklisting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_blacklisting;

    private LocalDateTime date_debut;
    private LocalDateTime date_fin;

    @ManyToOne
    @JoinColumn(name = "id_adherent", nullable = false)
    private Adherent adherent;

    public Integer getId_blacklisting() { return id_blacklisting; }
    public void setId_blacklisting(Integer id_blacklisting) { this.id_blacklisting = id_blacklisting; }

    public LocalDateTime getDate_debut() { return date_debut; }
    public void setDate_debut(LocalDateTime date_debut) { this.date_debut = date_debut; }

    public LocalDateTime getDate_fin() { return date_fin; }
    public void setDate_fin(LocalDateTime date_fin) { this.date_fin = date_fin; }

    public Adherent getAdherent() { return adherent; }
    public void setAdherent(Adherent adherent) { this.adherent = adherent; }
}