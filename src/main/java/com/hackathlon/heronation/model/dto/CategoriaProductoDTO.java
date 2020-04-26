package com.hackathlon.heronation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathlon.heronation.model.Preferencia;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.CategoriaProducto} entity.
 */
public class CategoriaProductoDTO implements Serializable {
    
    private Long id;

    private String nombre;

    private String descripcion;

    @JsonIgnore
    private List<Preferencia> usuariosEmpresa;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Preferencia> getUsuariosEmpresa() {
        return usuariosEmpresa;
    }

    public void setUsuariosEmpresa(List<Preferencia> usuariosEmpresa) {
        this.usuariosEmpresa = usuariosEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CategoriaProductoDTO categoriaProductoDTO = (CategoriaProductoDTO) o;
        if (categoriaProductoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), categoriaProductoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CategoriaProductoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuariosEmpresa=" + usuariosEmpresa +
                '}';
    }
}
