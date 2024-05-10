package com.ceica.padel.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreserva;
    private LocalDateTime fecha_reserva;

    @Column(name = "fecha_partido")
    private LocalDate fecha;

    @Column(name = "idhorario")
    private Integer idhorario;

    @Column(name = "idpista")
    private Integer idpista;

    public Reserva() {
    }

    public Reserva(LocalDateTime fecha_reserva, LocalDate fecha, Integer idhorario, Integer idpista) {
        this.fecha_reserva = fecha_reserva;
        this.fecha = fecha;
        this.idhorario = idhorario;
        this.idpista = idpista;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Integer getIdpista() {
        return idpista;
    }

    public void setIdpista(Integer idpista) {
        this.idpista = idpista;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idreserva=" + idreserva +
                ", fecha_reserva=" + fecha_reserva +
                ", fecha_partido=" + fecha +
                ", idhorario=" + idhorario +
                ", idpista=" + idpista +
                '}';
    }
}
