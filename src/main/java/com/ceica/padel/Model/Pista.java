package com.ceica.padel.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pista")
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpista;
    private String nombre;


    public Pista() {
    }

    public Integer getIdpista() {
        return idpista;
    }

    public void setIdpista(Integer idpista) {
        this.idpista = idpista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
