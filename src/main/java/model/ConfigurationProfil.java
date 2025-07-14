package model;

import javax.persistence.*;

@Entity
@Table(name = "Configuration_Profil")
public class ConfigurationProfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_configuration_profil;

    @Column(nullable = false)
    private Integer quota;

    @Column(nullable = false)
    private Integer nbr_prolongement;

    private Integer quota_reservation;

    public Integer getId_configuration_profil() { return id_configuration_profil; }
    public void setId_configuration_profil(Integer id_configuration_profil) { this.id_configuration_profil = id_configuration_profil; }

    public Integer getQuota() { return quota; }
    public void setQuota(Integer quota) { this.quota = quota; }

    public Integer getNbr_prolongement() { return nbr_prolongement; }
    public void setNbr_prolongement(Integer nbr_prolongement) { this.nbr_prolongement = nbr_prolongement; }

    public Integer getQuota_reservation() { return quota_reservation; }
    public void setQuota_reservation(Integer quota_reservation) { this.quota_reservation = quota_reservation; }
}