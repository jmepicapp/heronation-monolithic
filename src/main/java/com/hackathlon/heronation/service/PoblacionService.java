package com.hackathlon.heronation.service;

import com.hackathlon.heronation.service.dto.PoblacionDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.domain.Poblacion}.
 */
public interface PoblacionService {

    /**
     * Save a poblacion.
     *
     * @param poblacionDTO the entity to save.
     * @return the persisted entity.
     */
    PoblacionDTO save(PoblacionDTO poblacionDTO);

    /**
     * Get all the poblacions.
     *
     * @return the list of entities.
     */
    List<PoblacionDTO> findAll();

    /**
     * Get the "id" poblacion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PoblacionDTO> findOne(Long id);

    /**
     * Delete the "id" poblacion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
