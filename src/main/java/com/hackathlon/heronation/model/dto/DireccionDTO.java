package com.hackathlon.heronation.model.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.domain.Direccion} entity.
 */
public class DireccionDTO implements Serializable {
    
    private Long id;

    private String calle;

    private Integer codigoPostal;

    private Long poblacion;


    private Long direccionEmpresaId;

    private Long direccionDonanteId;

    private Long direccionPoblacionId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    public Long getDireccionEmpresaId() {
        return direccionEmpresaId;
    }

    public void setDireccionEmpresaId(Long usuarioEmpresaId) {
        this.direccionEmpresaId = usuarioEmpresaId;
    }

    public Long getDireccionDonanteId() {
        return direccionDonanteId;
    }

    public void setDireccionDonanteId(Long usuarioDonanteId) {
        this.direccionDonanteId = usuarioDonanteId;
    }

    public Long getDireccionPoblacionId() {
        return direccionPoblacionId;
    }

    public void setDireccionPoblacionId(Long poblacionId) {
        this.direccionPoblacionId = poblacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DireccionDTO direccionDTO = (DireccionDTO) o;
        if (direccionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), direccionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DireccionDTO{" +
            "id=" + getId() +
            ", calle='" + getCalle() + "'" +
            ", codigoPostal=" + getCodigoPostal() +
            ", poblacion=" + getPoblacion() +
            ", direccionEmpresaId=" + getDireccionEmpresaId() +
            ", direccionDonanteId=" + getDireccionDonanteId() +
            ", direccionPoblacionId=" + getDireccionPoblacionId() +
            "}";
    }
}
