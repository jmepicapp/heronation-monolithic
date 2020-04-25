package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "direccion")
    private Long direccion;

    @Column(name = "rol")
    private Long rol;

    @OneToMany(mappedBy = "usuarioDonante")
    private Set<Peticion> peticionUsuarioDonantes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("usuarioDonantes")
    private Rol rolUsuarioDonante;

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

    public String getEmail() {
        return email;
    }

    public UsuarioDonante email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getContrasena() {
        return contrasena;
    }

    public UsuarioDonante contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Long getDireccion() {
        return direccion;
    }

    public UsuarioDonante direccion(Long direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(Long direccion) {
        this.direccion = direccion;
    }

    public Long getRol() {
        return rol;
    }

    public UsuarioDonante rol(Long rol) {
        this.rol = rol;
        return this;
    }

    public void setRol(Long rol) {
        this.rol = rol;
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

    public Rol getRolUsuarioDonante() {
        return rolUsuarioDonante;
    }

    public UsuarioDonante rolUsuarioDonante(Rol rol) {
        this.rolUsuarioDonante = rol;
        return this;
    }

    public void setRolUsuarioDonante(Rol rol) {
        this.rolUsuarioDonante = rol;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

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
            ", email='" + getEmail() + "'" +
            ", telefono=" + getTelefono() +
            ", contrasena='" + getContrasena() + "'" +
            ", direccion=" + getDireccion() +
            ", rol=" + getRol() +
            "}";
    }
}
