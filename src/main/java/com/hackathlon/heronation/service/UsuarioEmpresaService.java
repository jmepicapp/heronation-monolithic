package com.hackathlon.heronation.service;

import com.hackathlon.heronation.service.dto.UsuarioEmpresaDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.domain.UsuarioEmpresa}.
 */
public interface UsuarioEmpresaService {

    /**
     * Save a usuarioEmpresa.
     *
     * @param usuarioEmpresaDTO the entity to save.
     * @return the persisted entity.
     */
    UsuarioEmpresaDTO save(UsuarioEmpresaDTO usuarioEmpresaDTO);

    /**
     * Get all the usuarioEmpresas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UsuarioEmpresaDTO> findAll(Pageable pageable);

    /**
     * Get the "id" usuarioEmpresa.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UsuarioEmpresaDTO> findOne(Long id);

    /**
     * Delete the "id" usuarioEmpresa.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
