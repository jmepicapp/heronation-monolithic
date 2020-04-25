package com.hackathlon.heronation.model;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A CategoriaEmpresa.
 */
@EntityScan
@Table(name = "categoria_empresa")
public class CategoriaEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany
    @JoinTable(name = "categoria_empresa_usuario_empresa",
               joinColumns = @JoinColumn(name = "categoria_empresa_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "usuario_empresa_id", referencedColumnName = "id"))
    private Set<UsuarioEmpresa> usuarioEmpresas = new HashSet<>();

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

    public CategoriaEmpresa nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaEmpresa descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<UsuarioEmpresa> getUsuarioEmpresas() {
        return usuarioEmpresas;
    }

    public CategoriaEmpresa usuarioEmpresas(Set<UsuarioEmpresa> usuarioEmpresas) {
        this.usuarioEmpresas = usuarioEmpresas;
        return this;
    }

    public CategoriaEmpresa addUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresas.add(usuarioEmpresa);
        usuarioEmpresa.getCategoriaEmpresas().add(this);
        return this;
    }

    public CategoriaEmpresa removeUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresas.remove(usuarioEmpresa);
        usuarioEmpresa.getCategoriaEmpresas().remove(this);
        return this;
    }

    public void setUsuarioEmpresas(Set<UsuarioEmpresa> usuarioEmpresas) {
        this.usuarioEmpresas = usuarioEmpresas;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CategoriaEmpresa)) {
            return false;
        }
        return id != null && id.equals(((CategoriaEmpresa) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CategoriaEmpresa{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            "}";
    }
}
