package com.hackathlon.heronation.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

    @Column(name = "descripcion_empresa")
    private String descripcionEmpresa;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_donante_id")
    @JsonIgnoreProperties("peticionUsuarioDonantes")
    private UsuarioDonante usuarioDonante;

    @ManyToOne
    @JoinColumn(name = "usuario_empresa_id")
    @JsonIgnoreProperties("peticionUsuarioEmpresas")
    private UsuarioEmpresa usuarioEmpresa;

    @OneToMany(mappedBy = "peticion", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Producto> listaProducto = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Peticion fechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    @PrePersist
    public void setFechaCreacion() {
        this.fechaCreacion = LocalDateTime.now();
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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
                "id=" + id +
                ", descripcionEmpresa='" + descripcionEmpresa + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                ", usuarioDonante=" + usuarioDonante +
                ", usuarioEmpresa=" + usuarioEmpresa +
                ", listaProducto=" + listaProducto +
                '}';
    }
}