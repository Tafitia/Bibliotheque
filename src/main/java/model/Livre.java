package model;

import javax.persistence.*;

@Entity
@Table(name = "Livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_livre;

    @Column(nullable = false)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_auteur", nullable = false)
    private Auteur auteur;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_categorie_pret", nullable = false)
    private CategoriePret categoriePret;

    public Integer getId_livre() { return id_livre; }
    public void setId_livre(Integer id_livre) { this.id_livre = id_livre; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public Auteur getAuteur() { return auteur; }
    public void setAuteur(Auteur auteur) { this.auteur = auteur; }

    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public CategoriePret getCategoriePret() { return categoriePret; }
    public void setCategoriePret(CategoriePret categoriePret) { this.categoriePret = categoriePret; }
}