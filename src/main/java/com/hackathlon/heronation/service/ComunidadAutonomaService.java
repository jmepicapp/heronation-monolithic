package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.ComunidadAutonomaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.ComunidadAutonoma}.
 */
public interface ComunidadAutonomaService {

    /**
     * Get all the comunidades autonomas.
     *
     * @return the list of entities.
     */
    List<ComunidadAutonomaDTO> findAll();

    /**
     * Get the "id" comunidad autonoma.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ComunidadAutonomaDTO> findOne(Long id);

}
