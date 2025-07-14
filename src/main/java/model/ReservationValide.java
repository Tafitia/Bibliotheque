package model;

import javax.persistence.*;

@Entity
@Table(name = "Reservtion_Valide")
public class ReservationValide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reservation_valide;

    @ManyToOne
    @JoinColumn(name = "id_reservation", nullable = false)
    private Reservation reservation;

    public Integer getId_reservation_valide() { return id_reservation_valide; }
    public void setId_reservation_valide(Integer id_reservation_valide) { this.id_reservation_valide = id_reservation_valide; }

    public Reservation getReservation() { return reservation; }
    public void setReservation(Reservation reservation) { this.reservation = reservation; }
}