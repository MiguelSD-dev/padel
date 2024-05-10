package com.ceica.padel.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idusuario;

    private String nombre;

    private Integer idreserva;

    private Boolean victoria;

    private LocalDate fecha;

    private String hora;

    private String pista;

    public Historico() {
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "id=" + id +
                ", idusuario=" + idusuario +
                ", nombre='" + nombre + '\'' +
                ", idreserva=" + idreserva +
                ", victoria=" + victoria +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", pista='" + pista + '\'' +
                '}';
    }
}
