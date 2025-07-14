package model;

import javax.persistence.*;

@Entity
@Table(name = "Auteur")
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_auteur;

    @Column(nullable = false)
    private String nom;

    public Integer getId_auteur() { return id_auteur; }
    public void setId_auteur(Integer id_auteur) { this.id_auteur = id_auteur; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}