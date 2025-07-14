package model;

import javax.persistence.*;

@Entity
@Table(name = "Type_Pret")
public class TypePret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type_pret;

    @Column(nullable = false)
    private String nom;

    public Integer getId_type_pret() { return id_type_pret; }
    public void setId_type_pret(Integer id_type_pret) { this.id_type_pret = id_type_pret; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}