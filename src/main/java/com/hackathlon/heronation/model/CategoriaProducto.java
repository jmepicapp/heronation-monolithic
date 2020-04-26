package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A CategoriaProducto.
 */
@Entity
@Table(name = "categoria_producto")
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "categoriaProducto")
    @JsonIgnore
    private List<Preferencia> usuariosEmpresa;

    public List<Preferencia> getUsuariosEmpresa() {
        return usuariosEmpresa;
    }

    public void setUsuariosEmpresa(List<Preferencia> usuariosEmpresa) {
        this.usuariosEmpresa = usuariosEmpresa;
    }

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

    public CategoriaProducto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaProducto descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CategoriaProducto)) {
            return false;
        }
        return id != null && id.equals(((CategoriaProducto) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
