package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @ManyToOne
    @JsonIgnoreProperties("usuarioDonantes")
    private Rol rolUsuario;

    public Rol getRolUsuarioDonante() {
        return rolUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario rolUsuario(Rol rol) {
        this.rolUsuario = rol;
        return this;
    }

    public void setRolUsuario(Rol rol) {
        this.rolUsuario = rol;
    }

}
