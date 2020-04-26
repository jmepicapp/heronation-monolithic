package com.hackathlon.heronation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathlon.heronation.model.Preferencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.UsuarioEmpresa} entity.
 */
public class UsuarioEmpresaDTO implements Serializable {
    
    private Long id;

    private String nombre;

    private Integer telefono;
    private DireccionDTO direccion;

    private Boolean activo;


    private RolDTO rolUsuarioEmpresaId;
    
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


    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

    public Boolean getActivo() {
        return activo;
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
