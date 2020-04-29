package com.hackathlon.heronation.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * A UsuarioEmpresa.
 */
@Entity
@Table(name = "usuario_empresa")
public class UsuarioEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private Integer telefono;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    @OneToMany(mappedBy = "usuarioEmpresa")
    private List<Preferencia> preferenciasCategoriaProductos = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioEmpresa")
    private List<Peticion> peticionUsuarioEmpresas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public UsuarioEmpresa nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public UsuarioEmpresa telefono(Integer telefono) {
        this.telefono = telefono;
        return this;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public UsuarioEmpresa direccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Preferencia> getPreferenciasCategoriaProductos() {
        return preferenciasCategoriaProductos;
    }

    public UsuarioEmpresa preferenciasCategoriaProductos(List<Preferencia> preferencias) {
        this.preferenciasCategoriaProductos = preferencias;
        return this;
    }

    public UsuarioEmpresa addPreferenciasCategoriaProductos(Preferencia preferencia) {
        this.preferenciasCategoriaProductos.add(preferencia);
        preferencia.setUsuarioEmpresa(this);
        return this;
    }

    public UsuarioEmpresa removePreferenciasCategoriaProductos(Preferencia preferencia) {
        this.preferenciasCategoriaProductos.remove(preferencia);
        preferencia.setUsuarioEmpresa(null);
        return this;
    }

    public void setPreferenciasCategoriaProductos(List<Preferencia> preferencias) {
        this.preferenciasCategoriaProductos = preferencias;
    }

    public List<Peticion> getPeticionUsuarioEmpresas() {
        return peticionUsuarioEmpresas;
    }

    public UsuarioEmpresa peticionUsuarioEmpresas(List<Peticion> peticions) {
        this.peticionUsuarioEmpresas = peticions;
        return this;
    }

    public UsuarioEmpresa addPeticionUsuarioEmpresa(Peticion peticion) {
        this.peticionUsuarioEmpresas.add(peticion);
        peticion.setUsuarioEmpresa(this);
        return this;
    }

    public UsuarioEmpresa removePeticionUsuarioEmpresa(Peticion peticion) {
        this.peticionUsuarioEmpresas.remove(peticion);
        peticion.setUsuarioEmpresa(null);
        return this;
    }

    public void setPeticionUsuarioEmpresas(List<Peticion> peticions) {
        this.peticionUsuarioEmpresas = peticions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsuarioEmpresa)) {
            return false;
        }
        return id != null && id.equals(((UsuarioEmpresa) o).id);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UsuarioEmpresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", direccion=" + direccion +
                ", preferenciasCategoriaProductos=" + preferenciasCategoriaProductos +
                ", peticionUsuarioEmpresas=" + peticionUsuarioEmpresas +
                ", usuario=" + usuario +
                '}';
    }
}
