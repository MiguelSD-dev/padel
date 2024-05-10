package com.ceica.padel.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_reserva")
public class UsuarioReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario_reserva")
    private Integer idusuarioReserva;

    private Integer idusuario;

    private Integer idreserva;

    private Boolean victoria;

    public UsuarioReserva() {
    }

    public UsuarioReserva(Integer idusuario, Integer idreserva, Boolean victoria) {
        this.idusuario = idusuario;
        this.idreserva = idreserva;
        this.victoria = victoria;
    }

    public Integer getIdusuarioReserva() {
        return idusuarioReserva;
    }

    public void setIdusuarioReserva(Integer idusuarioReserva) {
        this.idusuarioReserva = idusuarioReserva;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Boolean getVictoria() {
        return victoria;
    }

    public void setVictoria(Boolean victoria) {
        this.victoria = victoria;
    }
}
