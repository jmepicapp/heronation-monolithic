package com.hackathlon.heronation.model.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.UsuarioEmpresa} entity.
 */
public class UsuarioEmpresaDTO implements Serializable {

    private Long id;
    private String nombre;
    private Integer telefono;
    private DireccionDTO direccion;
    private UsuarioDTO usuario;

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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
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
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", direccion=" + direccion +
                ", usuario=" + usuario +
                '}';
    }
}
