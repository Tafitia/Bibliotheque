package model;

import javax.persistence.*;

@Entity
@Table(name = "Categorie_Pret")
public class CategoriePret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categorie_pret;

    @Column(nullable = false)
    private String nom;

    public Integer getId_categorie_pret() { return id_categorie_pret; }
    public void setId_categorie_pret(Integer id_categorie_pret) { this.id_categorie_pret = id_categorie_pret; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}