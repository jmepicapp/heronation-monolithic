package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.UsuarioDonanteDTO;
import com.hackathlon.heronation.model.dto.UsuarioDonanteFrontDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.UsuarioDonante}.
 */
public interface UsuarioDonanteService {

    /**
     * Save a usuarioDonante.
     *
     * @param usuarioDonanteFrontDTO the entity to save.
     * @return the persisted entity.
     */
    UsuarioDonanteDTO save(UsuarioDonanteFrontDTO usuarioDonanteFrontDTO);

    /**
     * Get all the usuarioDonantes.
     *
     * @return the list of entities.
     */
    List<UsuarioDonanteDTO> findAll();

    /**
     * Get the "id" usuarioDonante.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UsuarioDonanteDTO> findOne(Long id);

    /**
     * Get the "id" usuarioDonante.
     *
     * @param email the email of the entity usuario.
     * @return the entity.
     */
    Optional<UsuarioDonanteDTO> findByEmailUsuario(String email);

    /**
     * Delete the "id" usuarioDonante.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
