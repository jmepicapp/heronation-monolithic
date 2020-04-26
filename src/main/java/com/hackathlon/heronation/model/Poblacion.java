package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathlon.heronation.model.Provincia;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Poblacion.
 */
@Entity
@Table(name = "poblacion")
public class Poblacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JsonIgnoreProperties("poblacions")
    private Provincia poblacionProvincia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Poblacion nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getPoblacionProvincia() {
        return poblacionProvincia;
    }

    public Poblacion poblacionProvincia(Provincia provincia) {
        this.poblacionProvincia = provincia;
        return this;
    }

    public void setPoblacionProvincia(Provincia provincia) {
        this.poblacionProvincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Poblacion)) {
            return false;
        }
        return id != null && id.equals(((Poblacion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Poblacion{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", provincia=" + getPoblacionProvincia() +
            "}";
    }
}
