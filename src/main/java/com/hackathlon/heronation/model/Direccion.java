package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathlon.heronation.model.Poblacion;
import com.hackathlon.heronation.model.UsuarioDonante;
import com.hackathlon.heronation.model.UsuarioEmpresa;

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

    @Column(name = "poblacion")
    private Long poblacion;

    @OneToOne
    @JoinColumn(unique = true)
    private UsuarioEmpresa direccionEmpresa;

    @OneToOne
    @JoinColumn(unique = true)
    private UsuarioDonante direccionDonante;

    @ManyToOne
    @JsonIgnoreProperties("direccions")
    private Poblacion direccionPoblacion;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
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

    public Long getPoblacion() {
        return poblacion;
    }

    public Direccion poblacion(Long poblacion) {
        this.poblacion = poblacion;
        return this;
    }

    public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    public UsuarioEmpresa getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public Direccion direccionEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.direccionEmpresa = usuarioEmpresa;
        return this;
    }

    public void setDireccionEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.direccionEmpresa = usuarioEmpresa;
    }

    public UsuarioDonante getDireccionDonante() {
        return direccionDonante;
    }

    public Direccion direccionDonante(UsuarioDonante usuarioDonante) {
        this.direccionDonante = usuarioDonante;
        return this;
    }

    public void setDireccionDonante(UsuarioDonante usuarioDonante) {
        this.direccionDonante = usuarioDonante;
    }

    public Poblacion getDireccionPoblacion() {
        return direccionPoblacion;
    }

    public Direccion direccionPoblacion(Poblacion poblacion) {
        this.direccionPoblacion = poblacion;
        return this;
    }

    public void setDireccionPoblacion(Poblacion poblacion) {
        this.direccionPoblacion = poblacion;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

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
            "id=" + getId() +
            ", calle='" + getCalle() + "'" +
            ", codigoPostal=" + getCodigoPostal() +
            ", poblacion=" + getPoblacion() +
            "}";
    }
}
