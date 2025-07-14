package model;

import javax.persistence.*;

@Entity
@Table(name = "Type_Penalite")
public class TypePenalite {
    @Id
    private Integer id_type_penalite;

    private String nom;

    public Integer getId_type_penalite() { return id_type_penalite; }
    public void setId_type_penalite(Integer id_type_penalite) { this.id_type_penalite = id_type_penalite; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}