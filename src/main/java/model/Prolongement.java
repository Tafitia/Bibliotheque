package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Prolongement")
public class Prolongement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prolongement;

    @Column(nullable = false)
    private LocalDateTime date_retour;

    @ManyToOne
    @JoinColumn(name = "id_pret", nullable = false)
    private Pret pret;

    public Integer getId_prolongement() { return id_prolongement; }
    public void setId_prolongement(Integer id_prolongement) { this.id_prolongement = id_prolongement; }

    public LocalDateTime getDate_retour() { return date_retour; }
    public void setDate_retour(LocalDateTime date_retour) { this.date_retour = date_retour; }

    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }
}