package com.hackathlon.heronation.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PreferenciaId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "usuario_empresa_id")
    private Long usuarioEmpresaId;

    @Column(name = "categoria_producto_id")
    private Long categoriaProductoId;

    public PreferenciaId() {
    }

    public PreferenciaId(Long usuarioEmpresaId, Long categoriaProductoId) {
        this.usuarioEmpresaId = usuarioEmpresaId;
        this.categoriaProductoId = categoriaProductoId;
    }

    public Long getUsuarioEmpresaId() {
        return usuarioEmpresaId;
    }

    public void setUsuarioEmpresaId(Long usuarioEmpresa) {
        this.usuarioEmpresaId = usuarioEmpresa;
    }

    public Long getCategoriaProductoId() {
        return categoriaProductoId;
    }

    public void setCategoriaProductoId(Long categoriaProducto) {
        this.categoriaProductoId = categoriaProducto;
    }

    @Override
    public String toString() {
        return "PreferenciaId{" +
                "usuarioEmpresa=" + usuarioEmpresaId +
                ", categoriaProducto=" + categoriaProductoId +
                '}';
    }
}
