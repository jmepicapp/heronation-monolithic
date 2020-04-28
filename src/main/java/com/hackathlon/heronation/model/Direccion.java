package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Direccion.
 */
@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calle")
    private String calle;

    @Column(name = "codigo_postal")
    private Integer codigoPostal;

    @ManyToOne(cascade=CascadeType.ALL)
    @JsonIgnoreProperties("poblacion")
    private Poblacion poblacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordenada_id", referencedColumnName = "id")
    private Coordenada coordenada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public Direccion calle(String calle) {
        this.calle = calle;
        return this;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public Direccion codigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
        return this;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    public Poblacion getPoblacion() {
        return poblacion;
    }

    public Direccion Poblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
        return this;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Direccion)) {
            return false;
        }
        return id != null && id.equals(((Direccion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", poblacion=" + poblacion +
                ", coordenada=" + coordenada +
                '}';
    }
}
