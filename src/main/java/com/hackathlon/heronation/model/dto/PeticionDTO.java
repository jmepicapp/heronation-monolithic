package com.hackathlon.heronation.model.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.domain.Peticion} entity.
 */
public class PeticionDTO implements Serializable {
    
    private Long id;

    private Long empresa;

    private Long donante;

    private String descripcionDonante;

    private String descripcionEmpresa;

    private ZonedDateTime fecha;

    private Long usuarioDonanteId;

    private Long usuarioEmpresaId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public Long getDonante() {
        return donante;
    }

    public void setDonante(Long donante) {
        this.donante = donante;
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

    public Long getUsuarioDonanteId() {
        return usuarioDonanteId;
    }

    public void setUsuarioDonanteId(Long usuarioDonanteId) {
        this.usuarioDonanteId = usuarioDonanteId;
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
            ", empresa=" + getEmpresa() +
            ", donante=" + getDonante() +
            ", descripcionDonante='" + getDescripcionDonante() + "'" +
            ", descripcionEmpresa='" + getDescripcionEmpresa() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", usuarioDonanteId=" + getUsuarioDonanteId() +
            ", usuarioEmpresaId=" + getUsuarioEmpresaId() +
            "}";
    }
}
