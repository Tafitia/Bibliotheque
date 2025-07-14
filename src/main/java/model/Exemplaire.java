package model;

import javax.persistence.*;

@Entity
@Table(name = "Exemplaire")
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_exemplaire;

    @Column(name = "Reference", nullable = false)
    private String reference;

    @ManyToOne
    @JoinColumn(name = "id_livre", nullable = false)
    private Livre livre;

    public Integer getId_exemplaire() { return id_exemplaire; }
    public void setId_exemplaire(Integer id_exemplaire) { this.id_exemplaire = id_exemplaire; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public Livre getLivre() { return livre; }
    public void setLivre(Livre livre) { this.livre = livre; }
}