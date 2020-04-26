package com.hackathlon.heronation.model.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.domain.CategoriaProducto} entity.
 */
public class CategoriaProductoDTO implements Serializable {
    
    private Long id;

    private String nombre;

    private String descripcion;


    private Long preferenciaId;
    
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

    public Long getPreferenciaId() {
        return preferenciaId;
    }

    public void setPreferenciaId(Long preferenciaId) {
        this.preferenciaId = preferenciaId;
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
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", preferenciaId=" + getPreferenciaId() +
            "}";
    }
}