package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Penalite")
public class Penalite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_penalite;

    private String justificatif;

    private LocalDateTime date_penalite;

    @ManyToOne
    @JoinColumn(name = "id_type_penalite", nullable = false)
    private TypePenalite typePenalite;

    @ManyToOne
    @JoinColumn(name = "id_adherent", nullable = false)
    private Adherent adherent;

    public Integer getId_penalite() { return id_penalite; }
    public void setId_penalite(Integer id_penalite) { this.id_penalite = id_penalite; }

    public String getJustificatif() { return justificatif; }
    public void setJustificatif(String justificatif) { this.justificatif = justificatif; }

    public LocalDateTime getDate_penalite() { return date_penalite; }
    public void setDate_penalite(LocalDateTime date_penalite) { this.date_penalite = date_penalite; }

    public TypePenalite getTypePenalite() { return typePenalite; }
    public void setTypePenalite(TypePenalite typePenalite) { this.typePenalite = typePenalite; }

    public Adherent getAdherent() { return adherent; }
    public void setAdherent(Adherent adherent) { this.adherent = adherent; }
}