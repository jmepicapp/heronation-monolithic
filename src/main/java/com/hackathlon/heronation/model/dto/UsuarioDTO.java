package com.hackathlon.heronation.model.dto;

import com.hackathlon.heronation.model.Rol;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.Rol} entity.
 */
public class UsuarioDTO implements Serializable {

    private Long id;
    private String email;
    private String password;
    private Boolean activo;
    private Rol rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsuarioDTO rolDTO = (UsuarioDTO) o;
        if (rolDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rolDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activo=" + activo +
                ", rol=" + rol +
                '}';
    }
}
