package model;

import javax.persistence.*;

@Entity
@Table(name = "Profil")
public class Profil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profil;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_configuration_profil", nullable = false)
    private ConfigurationProfil configurationProfil;

    public Integer getId_profil() { return id_profil; }
    public void setId_profil(Integer id_profil) { this.id_profil = id_profil; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public ConfigurationProfil getConfigurationProfil() { return configurationProfil; }
    public void setConfigurationProfil(ConfigurationProfil configurationProfil) { this.configurationProfil = configurationProfil; }
}