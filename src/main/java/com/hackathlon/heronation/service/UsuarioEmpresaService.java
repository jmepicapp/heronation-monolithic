package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.model.dto.UsuarioEmpresaDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.UsuarioEmpresa}.
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
     * @return the list of entities.
     */
    List<UsuarioEmpresaDTO> findAll();

    /**
     * Get all the preferencias.
     *
     * @param id the categoriaProducto id
     * @return the list of entities.
     */
    List<UsuarioEmpresaDTO> findAllEmpresasByCategoriaProducto(List<Long> id);

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
