package model;

import javax.persistence.*;

@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categorie;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private Integer restriction;

    public Integer getId_categorie() { return id_categorie; }
    public void setId_categorie(Integer id_categorie) { this.id_categorie = id_categorie; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Integer getRestriction() { return restriction; }
    public void setRestriction(Integer restriction) { this.restriction = restriction; }
}