package com.hackathlon.heronation.service;

import com.hackathlon.heronation.service.dto.CategoriaProductoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.domain.CategoriaProducto}.
 */
public interface CategoriaProductoService {

    /**
     * Save a categoriaProducto.
     *
     * @param categoriaProductoDTO the entity to save.
     * @return the persisted entity.
     */
    CategoriaProductoDTO save(CategoriaProductoDTO categoriaProductoDTO);

    /**
     * Get all the categoriaProductos.
     *
     * @return the list of entities.
     */
    List<CategoriaProductoDTO> findAll();

    /**
     * Get the "id" categoriaProducto.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CategoriaProductoDTO> findOne(Long id);

    /**
     * Delete the "id" categoriaProducto.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
