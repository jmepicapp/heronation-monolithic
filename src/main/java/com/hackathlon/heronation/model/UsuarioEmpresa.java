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

    @Column(name = "telefono")
    private Integer telefono;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuarioEmpresas;

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

    public Long getCategoria() {
        return categoria;
    }

    public UsuarioEmpresa categoria(Long categoria) {
        this.categoria = categoria;
        return this;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
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

    public Boolean getActivo() {
        return activo;
    }

    public Usuario getUsuarioEmpresas() {
        return usuarioEmpresas;
    }

    public void setUsuarioEmpresas(Usuario usuarioEmpresas) {
        this.usuarioEmpresas = usuarioEmpresas;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UsuarioEmpresa{" +
            "id=" + getId() +
            ", cif=" + getCif() +
            ", nombre='" + getNombre() + "'" +
            ", telefono=" + getTelefono() +
            ", direccion=" + getDireccion() +
            ", activo='" + isActivo() + "'" +
            ", categoria=" + getCategoria() +
            "}";
    }
}
