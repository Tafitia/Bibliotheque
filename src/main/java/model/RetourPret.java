package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Retour_Pret")
public class RetourPret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_retour_pret;

    @Column(nullable = false)
    private LocalDateTime date_retourne;

    @ManyToOne
    @JoinColumn(name = "id_pret", nullable = false)
    private Pret pret;

    public Integer getId_retour_pret() { return id_retour_pret; }
    public void setId_retour_pret(Integer id_retour_pret) { this.id_retour_pret = id_retour_pret; }

    public LocalDateTime getDate_retourne() { return date_retourne; }
    public void setDate_retourne(LocalDateTime date_retourne) { this.date_retourne = date_retourne; }

    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }
}