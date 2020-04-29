package com.hackathlon.heronation.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.*;

/**
 * A UsuarioDonante.
 */
@Entity
@Table(name = "usuario_donante")
public class UsuarioDonante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "telefono")
    private Integer telefono;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    @OneToMany(mappedBy = "usuarioDonante")
    private List<Peticion> peticionUsuarioDonantes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public UsuarioDonante nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public UsuarioDonante apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public UsuarioDonante telefono(Integer telefono) {
        this.telefono = telefono;
        return this;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public UsuarioDonante direccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    public List<Peticion> getPeticionUsuarioDonantes() {
        return peticionUsuarioDonantes;
    }

    public UsuarioDonante peticionUsuarioDonantes(List<Peticion> peticions) {
        this.peticionUsuarioDonantes = peticions;
        return this;
    }

    public UsuarioDonante addPeticionUsuarioDonante(Peticion peticion) {
        this.peticionUsuarioDonantes.add(peticion);
        peticion.setUsuarioDonante(this);
        return this;
    }

    public UsuarioDonante removePeticionUsuarioDonante(Peticion peticion) {
        this.peticionUsuarioDonantes.remove(peticion);
        peticion.setUsuarioDonante(null);
        return this;
    }

    public void setPeticionUsuarioDonantes(List<Peticion> peticions) {
        this.peticionUsuarioDonantes = peticions;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsuarioDonante)) {
            return false;
        }
        return id != null && id.equals(((UsuarioDonante) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UsuarioDonante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                ", direccion=" + direccion +
                ", peticionUsuarioDonantes=" + peticionUsuarioDonantes +
                ", usuario=" + usuario +
                '}';
    }
}
