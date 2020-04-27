package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.model.dto.UsuarioEmpresaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.Preferencia}.
 */
public interface PreferenciaService {

    /**
     * Save a preferencia.
     *
     * @param preferenciaDTO the entity to save.
     * @return the persisted entity.
     */
    PreferenciaDTO save(PreferenciaDTO preferenciaDTO);

    /**
     * Get all the preferencias.
     *
     * @return the list of entities.
     */
    List<PreferenciaDTO> findAll();

    /**
     * Get all the preferencias.
     *
     * @param id the categoriaProducto id
     * @return the list of entities.
     */
    List<PreferenciaDTO> findAllByCategoriaProducto(List<Long> id);

    /**
     * Get all the preferencias.
     *
     * @param idEmpresa the usuario empresa id
     * @return the list of entities.
     */
    List<PreferenciaDTO> findAllByUsuarioEmpresa(Long idEmpresa);

    /**
     * Get the "id" preferencia.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PreferenciaDTO> findOne(Long id);

    /**
     * Delete the "id" preferencia.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
