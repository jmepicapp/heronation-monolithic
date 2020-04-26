package com.hackathlon.heronation.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A UsuarioEmpresa.
 */
@Entity
@Table(name = "usuario_empresa")
public class UsuarioEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cif")
    private Long cif;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "direccion")
    private Long direccion;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "categoria")
    private Long categoria;

    @OneToMany(mappedBy = "usuarioEmpresa")
    private Set<Preferencia> preferenciaUsuarioEmpresas = new HashSet<>();

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

    public Long getCif() {
        return cif;
    }

    public UsuarioEmpresa cif(Long cif) {
        this.cif = cif;
        return this;
    }

    public void setCif(Long cif) {
        this.cif = cif;
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

    public Long getDireccion() {
        return direccion;
    }

    public UsuarioEmpresa direccion(Long direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(Long direccion) {
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

    public Set<Preferencia> getPreferenciaUsuarioEmpresas() {
        return preferenciaUsuarioEmpresas;
    }

    public UsuarioEmpresa preferenciaUsuarioEmpresas(Set<Preferencia> preferencias) {
        this.preferenciaUsuarioEmpresas = preferencias;
        return this;
    }

    public UsuarioEmpresa addPreferenciaUsuarioEmpresa(Preferencia preferencia) {
        this.preferenciaUsuarioEmpresas.add(preferencia);
        preferencia.setUsuarioEmpresa(this);
        return this;
    }

    public UsuarioEmpresa removePreferenciaUsuarioEmpresa(Preferencia preferencia) {
        this.preferenciaUsuarioEmpresas.remove(preferencia);
        preferencia.setUsuarioEmpresa(null);
        return this;
    }

    public void setPreferenciaUsuarioEmpresas(Set<Preferencia> preferencias) {
        this.preferenciaUsuarioEmpresas = preferencias;
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

    public Set<CategoriaEmpresa> getCategoriaEmpresas() {
        return categoriaEmpresas;
    }

    public UsuarioEmpresa categoriaEmpresas(Set<CategoriaEmpresa> categoriaEmpresas) {
        this.categoriaEmpresas = categoriaEmpresas;
        return this;
    }

    public UsuarioEmpresa addCategoriaEmpresa(CategoriaEmpresa categoriaEmpresa) {
        this.categoriaEmpresas.add(categoriaEmpresa);
        categoriaEmpresa.getUsuarioEmpresas().add(this);
        return this;
    }

    public UsuarioEmpresa removeCategoriaEmpresa(CategoriaEmpresa categoriaEmpresa) {
        this.categoriaEmpresas.remove(categoriaEmpresa);
        categoriaEmpresa.getUsuarioEmpresas().remove(this);
        return this;
    }

    public void setCategoriaEmpresas(Set<CategoriaEmpresa> categoriaEmpresas) {
        this.categoriaEmpresas = categoriaEmpresas;
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
