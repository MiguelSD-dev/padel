package com.ceica.padel.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String nombre;
    private String clave;
    private String dni;

    public Usuario() {
    }

    public Usuario(String nombre, String clave, String dni) {
        this.nombre = nombre;
        this.clave = clave;
        this.dni = dni;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "User{" +
                "idusuario=" + idusuario +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
