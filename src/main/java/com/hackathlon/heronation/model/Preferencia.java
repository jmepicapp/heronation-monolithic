package com.hackathlon.heronation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Preferencia.
 */
@Entity
@Table(name = "preferencia")
public class Preferencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PreferenciaId id;

    @ManyToOne
    @MapsId("usuarioEmpresaId")
    @JoinColumn(name = "usuario_empresa_id")
    @JsonIgnore
    private UsuarioEmpresa usuarioEmpresa;

    @ManyToOne
    @MapsId("categoriaProductoId")
    @JoinColumn(name = "categoria_producto_id")
    private CategoriaProducto categoriaProducto;

    @Column(name = "necesidad")
    private Boolean necesidad;

    @Column(name = "exclusion")
    private Boolean exclusion;

    public PreferenciaId getId() {
        return id;
    }

    public void setId(PreferenciaId id) {
        this.id = id;
    }

    public UsuarioEmpresa getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public Boolean getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(Boolean necesidad) {
        this.necesidad = necesidad;
    }

    public Boolean getExclusion() {
        return exclusion;
    }

    public void setExclusion(Boolean exclusion) {
        this.exclusion = exclusion;
    }

    public Preferencia exclusion(Boolean exclusion) {
        this.exclusion = exclusion;
        return this;
    }

    public Preferencia usuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
        return this;
    }

    public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Preferencia)) {
            return false;
        }
        return id != null && id.equals(((Preferencia) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Preferencia{" +
                "id=" + id +
                ", usuarioEmpresa=" + usuarioEmpresa +
                ", categoriaProducto=" + categoriaProducto +
                ", exclusion=" + exclusion +
                '}';
    }
}
