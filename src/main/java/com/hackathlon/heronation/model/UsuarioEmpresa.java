package com.hackathlon.heronation.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * A UsuarioEmpresa.
 */
@Entity
@Table(name = "usuario_empresa")
public class UsuarioEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "direccion")
    private Direccion direccion;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "rol")
    private Rol rol;

    @OneToMany(mappedBy = "usuarioEmpresa")
    private List<Preferencia> preferenciasCategoriaProductos = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioEmpresa")
    private Set<Peticion> peticionUsuarioEmpresas = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    private Rol rolUsuarioEmpresa;

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

    public UsuarioEmpresa nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioEmpresa email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public UsuarioEmpresa telefono(Integer telefono) {
        this.telefono = telefono;
        return this;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public UsuarioEmpresa contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public UsuarioEmpresa direccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Boolean isActivo() {
        return activo;
    }

    public UsuarioEmpresa activo(Boolean activo) {
        this.activo = activo;
        return this;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return rol;
    }

    public UsuarioEmpresa rol(Rol rol) {
        this.rol = rol;
        return this;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public List<Preferencia> getPreferenciasCategoriaProductos() {
        return preferenciasCategoriaProductos;
    }

    public UsuarioEmpresa preferenciasCategoriaProductos(List<Preferencia> preferencias) {
        this.preferenciasCategoriaProductos = preferencias;
        return this;
    }

    public UsuarioEmpresa addPreferenciasCategoriaProductos(Preferencia preferencia) {
        this.preferenciasCategoriaProductos.add(preferencia);
        preferencia.setUsuarioEmpresa(this);
        return this;
    }

    public UsuarioEmpresa removePreferenciasCategoriaProductos(Preferencia preferencia) {
        this.preferenciasCategoriaProductos.remove(preferencia);
        preferencia.setUsuarioEmpresa(null);
        return this;
    }

    public void setPreferenciasCategoriaProductos(List<Preferencia> preferencias) {
        this.preferenciasCategoriaProductos = preferencias;
    }

    public Set<Peticion> getPeticionUsuarioEmpresas() {
        return peticionUsuarioEmpresas;
    }

    public UsuarioEmpresa peticionUsuarioEmpresas(Set<Peticion> peticions) {
        this.peticionUsuarioEmpresas = peticions;
        return this;
    }

    public UsuarioEmpresa addPeticionUsuarioEmpresa(Peticion peticion) {
        this.peticionUsuarioEmpresas.add(peticion);
        peticion.setUsuarioEmpresa(this);
        return this;
    }

    public UsuarioEmpresa removePeticionUsuarioEmpresa(Peticion peticion) {
        this.peticionUsuarioEmpresas.remove(peticion);
        peticion.setUsuarioEmpresa(null);
        return this;
    }

    public void setPeticionUsuarioEmpresas(Set<Peticion> peticions) {
        this.peticionUsuarioEmpresas = peticions;
    }

    public Rol getRolUsuarioEmpresa() {
        return rolUsuarioEmpresa;
    }

    public UsuarioEmpresa rolUsuarioEmpresa(Rol rol) {
        this.rolUsuarioEmpresa = rol;
        return this;
    }

    public void setRolUsuarioEmpresa(Rol rol) {
        this.rolUsuarioEmpresa = rol;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsuarioEmpresa)) {
            return false;
        }
        return id != null && id.equals(((UsuarioEmpresa) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UsuarioEmpresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", contrasena='" + contrasena + '\'' +
                ", direccion=" + direccion +
                ", activo=" + activo +
                ", rol=" + rol +
                ", preferenciasCategoriaProductos=" + preferenciasCategoriaProductos +
                ", peticionUsuarioEmpresas=" + peticionUsuarioEmpresas +
                ", rolUsuarioEmpresa=" + rolUsuarioEmpresa +
                '}';
    }
}
