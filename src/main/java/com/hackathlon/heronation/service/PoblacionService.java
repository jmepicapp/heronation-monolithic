package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.PoblacionDTO;
import com.hackathlon.heronation.model.dto.ProvinciaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.Poblacion}.
 */
public interface PoblacionService {

    /**
     * Get all the poblacions.
     *
     * @return the list of entities.
     */
    List<PoblacionDTO> findAll();

    /**
     * Get all the provincias by comunidad.
     *
     * @param id the provincia_id
     * @return the list of entities.
     */
    List<PoblacionDTO> findAllByProvincia(Long id);

    /**
     * Get the "id" poblacion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PoblacionDTO> findOne(Long id);

}
