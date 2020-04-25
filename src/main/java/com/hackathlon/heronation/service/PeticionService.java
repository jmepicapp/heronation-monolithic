package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.PeticionDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.Peticion}.
 */
public interface PeticionService {

    /**
     * Save a peticion.
     *
     * @param peticionDTO the entity to save.
     * @return the persisted entity.
     */
    PeticionDTO save(PeticionDTO peticionDTO);

    /**
     * Get all the peticions.
     *
     * @return the list of entities.
     */
    List<PeticionDTO> findAll();

    /**
     * Get the "id" peticion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PeticionDTO> findOne(Long id);

    /**
     * Delete the "id" peticion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
