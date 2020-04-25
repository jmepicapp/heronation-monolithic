package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.CategoriaProducto;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CategoriaProducto entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Long> {
}
