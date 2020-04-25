package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.RolDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.Rol}.
 */
public interface RolService {

    /**
     * Save a rol.
     *
     * @param rolDTO the entity to save.
     * @return the persisted entity.
     */
    RolDTO save(RolDTO rolDTO);

    /**
     * Get all the rols.
     *
     * @return the list of entities.
     */
    List<RolDTO> findAll();

    /**
     * Get the "id" rol.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RolDTO> findOne(Long id);

    /**
     * Delete the "id" rol.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
