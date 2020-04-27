package com.hackathlon.heronation.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Peticion.
 */
@Entity
@Table(name = "peticion")
public class Peticion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion_donante")
    private String descripcionDonante;

    @Column(name = "descripcion_empresa")
    private String descripcionEmpresa;

    @Column(name = "fecha")
    private ZonedDateTime fecha;

    @ManyToOne
    @JsonIgnoreProperties("peticionUsuarioDonantes")
    private UsuarioDonante usuarioDonante;

    @ManyToOne
    @JsonIgnoreProperties("peticionUsuarioEmpresas")
    private UsuarioEmpresa usuarioEmpresa;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionDonante() {
        return descripcionDonante;
    }

    public Peticion descripcionDonante(String descripcionDonante) {
        this.descripcionDonante = descripcionDonante;
        return this;
    }

    public void setDescripcionDonante(String descripcionDonante) {
        this.descripcionDonante = descripcionDonante;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public Peticion descripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
        return this;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public ZonedDateTime getFecha() {
        return fecha;
    }

    public Peticion fecha(ZonedDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public void setFecha(ZonedDateTime fecha) {
        this.fecha = fecha;
    }

    public UsuarioDonante getUsuarioDonante() {
        return usuarioDonante;
    }

    public Peticion usuarioDonante(UsuarioDonante usuarioDonante) {
        this.usuarioDonante = usuarioDonante;
        return this;
    }

    public void setUsuarioDonante(UsuarioDonante usuarioDonante) {
        this.usuarioDonante = usuarioDonante;
    }

    public UsuarioEmpresa getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public Peticion usuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
        return this;
    }

    public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Peticion)) {
            return false;
        }
        return id != null && id.equals(((Peticion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Peticion{" +
            "id=" + getId() +
            ", descripcionDonante='" + getDescripcionDonante() + "'" +
            ", descripcionEmpresa='" + getDescripcionEmpresa() + "'" +
            ", fecha='" + getFecha() + "'" +
            "}";
    }
}
