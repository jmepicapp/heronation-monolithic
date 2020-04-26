package com.hackathlon.heronation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathlon.heronation.model.CategoriaProducto;
import com.hackathlon.heronation.model.PreferenciaId;
import com.hackathlon.heronation.model.UsuarioEmpresa;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.Preferencia} entity.
 */
public class PreferenciaDTO implements Serializable {

    @JsonIgnore
    private PreferenciaId id;

    private UsuarioEmpresaDTO usuarioEmpresa;

    @JsonIgnore
    private CategoriaProductoDTO categoriaProducto;

    private Boolean necesidad;

    private Boolean exclusion;

    public PreferenciaId getId() {
        return id;
    }

    public void setId(PreferenciaId id) {
        this.id = id;
    }

    public UsuarioEmpresaDTO getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public void setUsuarioEmpresa(UsuarioEmpresaDTO usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }

    public CategoriaProductoDTO getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProductoDTO categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public Boolean getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(Boolean necesidad) {
        this.necesidad = necesidad;
    }

    public Boolean getExclusion() {
        return exclusion;
    }

    public void setExclusion(Boolean exclusion) {
        this.exclusion = exclusion;
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
                "id=" + id +
                ", usuarioEmpresa=" + usuarioEmpresa +
                ", categoriaProducto=" + categoriaProducto +
                ", necesidad=" + necesidad +
                ", exclusion=" + exclusion +
                '}';
    }
}
