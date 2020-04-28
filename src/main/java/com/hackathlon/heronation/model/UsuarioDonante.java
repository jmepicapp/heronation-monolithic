package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "direccion")
    private Direccion direccion;

    @OneToMany(mappedBy = "usuarioDonante")
    private Set<Peticion> peticionUsuarioDonantes = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuarioDonante;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
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


    public Set<Peticion> getPeticionUsuarioDonantes() {
        return peticionUsuarioDonantes;
    }

    public UsuarioDonante peticionUsuarioDonantes(Set<Peticion> peticions) {
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

    public void setPeticionUsuarioDonantes(Set<Peticion> peticions) {
        this.peticionUsuarioDonantes = peticions;
    }

    public Usuario getUsuarioDonante() {
        return usuarioDonante;
    }

    public void setUsuarioDonante(Usuario rolUsuarioDonante) {
        this.usuarioDonante = rolUsuarioDonante;
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
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", telefono=" + getTelefono() +
            ", direccion=" + getDireccion() +
            ", rol=" + getUsuarioDonante() +
            "}";
    }
}
