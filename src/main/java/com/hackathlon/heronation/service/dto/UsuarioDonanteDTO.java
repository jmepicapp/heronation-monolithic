package com.hackathlon.heronation.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.domain.UsuarioDonante} entity.
 */
public class UsuarioDonanteDTO implements Serializable {
    
    private Long id;

    private String nombre;

    private String apellidos;

    private String email;

    private Integer telefono;

    private String contrasena;

    private Long direccion;

    private Long rol;


    private Long rolUsuarioDonanteId;
    
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Long getDireccion() {
        return direccion;
    }

    public void setDireccion(Long direccion) {
        this.direccion = direccion;
    }

    public Long getRol() {
        return rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }

    public Long getRolUsuarioDonanteId() {
        return rolUsuarioDonanteId;
    }

    public void setRolUsuarioDonanteId(Long rolId) {
        this.rolUsuarioDonanteId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsuarioDonanteDTO usuarioDonanteDTO = (UsuarioDonanteDTO) o;
        if (usuarioDonanteDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), usuarioDonanteDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UsuarioDonanteDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono=" + getTelefono() +
            ", contrasena='" + getContrasena() + "'" +
            ", direccion=" + getDireccion() +
            ", rol=" + getRol() +
            ", rolUsuarioDonanteId=" + getRolUsuarioDonanteId() +
            "}";
    }
}
