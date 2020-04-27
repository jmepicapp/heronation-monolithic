package com.hackathlon.heronation.model.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.domain.Peticion} entity.
 */
public class PeticionDTO implements Serializable {
    
    private Long id;

    private String descripcionDonante;

    private String descripcionEmpresa;

    private ZonedDateTime fecha;

    private UsuarioDonanteDTO usuarioDonante;
    private UsuarioEmpresaDTO usuarioEmpresa;

    private String estado;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescripcionDonante() {
        return descripcionDonante;
    }

    public void setDescripcionDonante(String descripcionDonante) {
        this.descripcionDonante = descripcionDonante;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public ZonedDateTime getFecha() {
        return fecha;
    }

    public void setFecha(ZonedDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioDonanteDTO getUsuarioDonante() {
        return usuarioDonante;
    }

    public void setUsuarioDonante(UsuarioDonanteDTO usuarioDonante) {
        this.usuarioDonante = usuarioDonante;
    }

    public UsuarioEmpresaDTO getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public void setUsuarioEmpresa(UsuarioEmpresaDTO usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PeticionDTO peticionDTO = (PeticionDTO) o;
        if (peticionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), peticionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PeticionDTO{" +
            "id=" + getId() +
            ", descripcionDonante='" + getDescripcionDonante() + "'" +
            ", descripcionEmpresa='" + getDescripcionEmpresa() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", usuarioDonanteId=" + getUsuarioDonante() +
            ", usuarioEmpresaId=" + getUsuarioEmpresa() +
            "}";
    }
}
