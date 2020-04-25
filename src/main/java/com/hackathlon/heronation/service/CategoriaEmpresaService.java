package com.hackathlon.heronation.service;

import com.hackathlon.heronation.service.dto.CategoriaEmpresaDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.domain.CategoriaEmpresa}.
 */
public interface CategoriaEmpresaService {

    /**
     * Save a categoriaEmpresa.
     *
     * @param categoriaEmpresaDTO the entity to save.
     * @return the persisted entity.
     */
    CategoriaEmpresaDTO save(CategoriaEmpresaDTO categoriaEmpresaDTO);

    /**
     * Get all the categoriaEmpresas.
     *
     * @return the list of entities.
     */
    List<CategoriaEmpresaDTO> findAll();

    /**
     * Get all the categoriaEmpresas with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<CategoriaEmpresaDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" categoriaEmpresa.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CategoriaEmpresaDTO> findOne(Long id);

    /**
     * Delete the "id" categoriaEmpresa.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
