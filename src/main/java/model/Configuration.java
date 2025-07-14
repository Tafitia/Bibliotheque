package model;

import javax.persistence.*;

@Entity
@Table(name = "Configuration")
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_configuration;

    @Column(nullable = false)
    private Integer nbr_retard;

    @Column(nullable = false)
    private Integer nbr_mois;

    public Integer getId_configuration() { return id_configuration; }
    public void setId_configuration(Integer id_configuration) { this.id_configuration = id_configuration; }

    public Integer getNbr_retard() { return nbr_retard; }
    public void setNbr_retard(Integer nbr_retard) { this.nbr_retard = nbr_retard; }

    public Integer getNbr_mois() { return nbr_mois; }
    public void setNbr_mois(Integer nbr_mois) { this.nbr_mois = nbr_mois; }
}