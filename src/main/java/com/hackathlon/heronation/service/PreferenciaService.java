package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.PreferenciaDTO;

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