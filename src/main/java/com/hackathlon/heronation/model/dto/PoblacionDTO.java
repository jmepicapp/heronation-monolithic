package com.hackathlon.heronation.model.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.Poblacion} entity.
 */
public class PoblacionDTO implements Serializable {
    
    private Long id;

    private String nombre;

    private Long provincia;


    private Long poblacionProvinciaId;
    
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

    public Long getProvincia() {
        return provincia;
    }

    public void setProvincia(Long provincia) {
        this.provincia = provincia;
    }

    public Long getPoblacionProvinciaId() {
        return poblacionProvinciaId;
    }

    public void setPoblacionProvinciaId(Long provinciaId) {
        this.poblacionProvinciaId = provinciaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PoblacionDTO poblacionDTO = (PoblacionDTO) o;
        if (poblacionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), poblacionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PoblacionDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", provincia=" + getProvincia() +
            ", poblacionProvinciaId=" + getPoblacionProvinciaId() +
            "}";
    }
}
