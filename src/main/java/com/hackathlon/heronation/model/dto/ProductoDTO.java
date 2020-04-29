package com.hackathlon.heronation.model.dto;

import com.hackathlon.heronation.model.Peticion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hackathlon.heronation.model.Rol} entity.
 */
public class ProductoDTO implements Serializable {

    private Long id;
    private String name;
    private String quantity;
    private String mesure;
    private PeticionDTO peticion;
    private CategoriaProductoDTO category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
    }

    public PeticionDTO getPeticion() {
        return peticion;
    }

    public void setPeticion(PeticionDTO peticion) {
        this.peticion = peticion;
    }

    public CategoriaProductoDTO getCategory() {
        return category;
    }

    public void setCategory(CategoriaProductoDTO category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductoDTO rolDTO = (ProductoDTO) o;
        if (rolDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rolDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", mesure='" + mesure + '\'' +
                ", peticion=" + peticion +
                ", category=" + category +
                '}';
    }
}
