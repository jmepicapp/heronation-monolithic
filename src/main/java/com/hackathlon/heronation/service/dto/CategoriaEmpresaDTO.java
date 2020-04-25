package com.hackathlon.heronation.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.domain.CategoriaEmpresa} entity.
 */
public class CategoriaEmpresaDTO implements Serializable {
    
    private Long id;

    private String nombre;

    private String descripcion;

    private Set<UsuarioEmpresaDTO> usuarioEmpresas = new HashSet<>();
    
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

    public Set<UsuarioEmpresaDTO> getUsuarioEmpresas() {
        return usuarioEmpresas;
    }

    public void setUsuarioEmpresas(Set<UsuarioEmpresaDTO> usuarioEmpresas) {
        this.usuarioEmpresas = usuarioEmpresas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CategoriaEmpresaDTO categoriaEmpresaDTO = (CategoriaEmpresaDTO) o;
        if (categoriaEmpresaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), categoriaEmpresaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CategoriaEmpresaDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", usuarioEmpresas='" + getUsuarioEmpresas() + "'" +
            "}";
    }
}
