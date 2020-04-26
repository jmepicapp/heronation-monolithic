package com.hackathlon.heronation.model.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.UsuarioEmpresa} entity.
 */
public class UsuarioEmpresaDTO implements Serializable {
    
    private Long id;

    private Long cif;

    private String nombre;

    private Integer telefono;

    private Long direccion;

    private Boolean activo;

    private Long rol;

    private Long categoria;


    private Long rolUsuarioEmpresaId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCif() {
        return cif;
    }

    public void setCif(Long cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public Long getDireccion() {
        return direccion;
    }

    public void setDireccion(Long direccion) {
        this.direccion = direccion;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Long getRol() {
        return rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Long getRolUsuarioEmpresaId() {
        return rolUsuarioEmpresaId;
    }

    public void setRolUsuarioEmpresaId(Long rolId) {
        this.rolUsuarioEmpresaId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsuarioEmpresaDTO usuarioEmpresaDTO = (UsuarioEmpresaDTO) o;
        if (usuarioEmpresaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), usuarioEmpresaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UsuarioEmpresaDTO{" +
            "id=" + getId() +
            ", cif=" + getCif() +
            ", nombre='" + getNombre() + "'" +
            ", telefono=" + getTelefono() +
            ", direccion=" + getDireccion() +
            ", activo='" + isActivo() + "'" +
            ", rol=" + getRol() +
            ", categoria=" + getCategoria() +
            ", rolUsuarioEmpresaId=" + getRolUsuarioEmpresaId() +
            "}";
    }
}
