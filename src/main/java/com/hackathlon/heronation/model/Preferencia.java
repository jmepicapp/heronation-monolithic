package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Preferencia.
 */
@Entity
@Table(name = "preferencia")
public class Preferencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "categoria")
    private Long categoria;

    @Column(name = "exclusion")
    private Boolean exclusion;

    @OneToMany(mappedBy = "preferencia")
    private Set<CategoriaProducto> categoriaPreferencias = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("preferenciaUsuarioEmpresas")
    private UsuarioEmpresa usuarioEmpresa;

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

    public Preferencia nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Preferencia descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCategoria() {
        return categoria;
    }

    public Preferencia categoria(Long categoria) {
        this.categoria = categoria;
        return this;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Boolean isExclusion() {
        return exclusion;
    }

    public Preferencia exclusion(Boolean exclusion) {
        this.exclusion = exclusion;
        return this;
    }

    public void setExclusion(Boolean exclusion) {
        this.exclusion = exclusion;
    }

    public Set<CategoriaProducto> getCategoriaPreferencias() {
        return categoriaPreferencias;
    }

    public Preferencia categoriaPreferencias(Set<CategoriaProducto> categoriaProductos) {
        this.categoriaPreferencias = categoriaProductos;
        return this;
    }

    public Preferencia addCategoriaPreferencia(CategoriaProducto categoriaProducto) {
        this.categoriaPreferencias.add(categoriaProducto);
        categoriaProducto.setPreferencia(this);
        return this;
    }

    public Preferencia removeCategoriaPreferencia(CategoriaProducto categoriaProducto) {
        this.categoriaPreferencias.remove(categoriaProducto);
        categoriaProducto.setPreferencia(null);
        return this;
    }

    public void setCategoriaPreferencias(Set<CategoriaProducto> categoriaProductos) {
        this.categoriaPreferencias = categoriaProductos;
    }

    public UsuarioEmpresa getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public Preferencia usuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
        return this;
    }

    public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Preferencia)) {
            return false;
        }
        return id != null && id.equals(((Preferencia) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Preferencia{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", categoria=" + getCategoria() +
            ", exclusion='" + isExclusion() + "'" +
            "}";
    }
}
