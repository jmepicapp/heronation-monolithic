package com.hackathlon.heronation.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.domain.Preferencia} entity.
 */
public class PreferenciaDTO implements Serializable {
    
    private Long id;

    private String nombre;

    private String descripcion;

    private Long categoria;

    private Boolean exclusion;


    private Long usuarioEmpresaId;
    
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

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Boolean isExclusion() {
        return exclusion;
    }

    public void setExclusion(Boolean exclusion) {
        this.exclusion = exclusion;
    }

    public Long getUsuarioEmpresaId() {
        return usuarioEmpresaId;
    }

    public void setUsuarioEmpresaId(Long usuarioEmpresaId) {
        this.usuarioEmpresaId = usuarioEmpresaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PreferenciaDTO preferenciaDTO = (PreferenciaDTO) o;
        if (preferenciaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), preferenciaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PreferenciaDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", categoria=" + getCategoria() +
            ", exclusion='" + isExclusion() + "'" +
            ", usuarioEmpresaId=" + getUsuarioEmpresaId() +
            "}";
    }
}
