package com.hackathlon.heronation.service;

import java.util.List;
import java.util.Optional;

import com.hackathlon.heronation.model.dto.PeticionDTO;

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
     * Get all the peticiones by usuario id.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
    List<PeticionDTO> findAllByIdUsuario(Long idUsuario);
    
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
    
    /**
     * Get the historical of peticiones by usuario id for UsuarioDonante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<PeticionDTO> findAllByIdUsuarioDonanteEstadoCanceladoYAceptado(Long idUsuario);

    /**
     * Get the historical of peticiones by usuario id for UsuarioEmpresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<PeticionDTO> findAllByIdUsuarioEmpresaEstadoCanceladoYAceptado(Long idUsuario);
	
    /**
     * Get the pendant peticiones by usuario id for UsuarioDonante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<PeticionDTO> findAllByIdUsuarioDonanteEstadoPendiente(Long idUsuario);
	
    /**
     * Get the pendant peticiones by usuario id for UsuarioEmpresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<PeticionDTO> findAllByIdUsuarioEmpresaEstadoPendiente(Long idUsuario);
}
