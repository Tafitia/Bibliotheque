package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Jour_Ferie")
public class JourFerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ferie;

    @Column(nullable = false)
    private LocalDate date_ferie;

    public Integer getId_ferie() { return id_ferie; }
    public void setId_ferie(Integer id_ferie) { this.id_ferie = id_ferie; }

    public LocalDate getDate_ferie() { return date_ferie; }
    public void setDate_ferie(LocalDate date_ferie) { this.date_ferie = date_ferie; }
}