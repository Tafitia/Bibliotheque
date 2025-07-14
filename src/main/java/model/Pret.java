package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pret")
public class Pret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pret;

    @Column(nullable = false)
    private LocalDateTime date_pret;

    @Column(nullable = false)
    private LocalDateTime date_retour;

    @ManyToOne
    @JoinColumn(name = "id_type_pret", nullable = false)
    private TypePret typePret;

    @ManyToOne
    @JoinColumn(name = "id_exemplaire", nullable = false)
    private Exemplaire exemplaire;

    @ManyToOne
    @JoinColumn(name = "id_adherent", nullable = false)
    private Adherent adherent;

    public Integer getId_pret() { return id_pret; }
    public void setId_pret(Integer id_pret) { this.id_pret = id_pret; }

    public LocalDateTime getDate_pret() { return date_pret; }
    public void setDate_pret(LocalDateTime date_pret) { this.date_pret = date_pret; }

    public LocalDateTime getDate_retour() { return date_retour; }
    public void setDate_retour(LocalDateTime date_retour) { this.date_retour = date_retour; }

    public TypePret getTypePret() { return typePret; }
    public void setTypePret(TypePret typePret) { this.typePret = typePret; }

    public Exemplaire getExemplaire() { return exemplaire; }
    public void setExemplaire(Exemplaire exemplaire) { this.exemplaire = exemplaire; }

    public Adherent getAdherent() { return adherent; }
    public void setAdherent(Adherent adherent) { this.adherent = adherent; }
}