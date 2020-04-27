package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.PeticionService;
import com.hackathlon.heronation.model.Peticion;
import com.hackathlon.heronation.repository.PeticionRepository;
import com.hackathlon.heronation.model.dto.PeticionDTO;
import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Peticion}.
 */
@Service
@Transactional
public class PeticionServiceImpl implements PeticionService {

    private final Logger log = LoggerFactory.getLogger(PeticionServiceImpl.class);

    @Autowired
    private final PeticionRepository peticionRepository;

    public PeticionServiceImpl(PeticionRepository peticionRepository) {
        this.peticionRepository = peticionRepository;
    }

    /**
     * Save a peticion.
     *
     * @param peticionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PeticionDTO save(PeticionDTO peticionDTO) {
        log.debug("Request to save Peticion : {}", peticionDTO);
        Peticion peticion = ModelMapperUtils.map(peticionDTO, Peticion.class);
        peticion = peticionRepository.save(peticion);
        return ModelMapperUtils.map(peticion, PeticionDTO.class);
    }

    /**
     * Get all the peticions.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PeticionDTO> findAll() {
        log.debug("Request to get all Peticions");
        return ModelMapperUtils.mapAll(peticionRepository.findAll(), PeticionDTO.class);

    }
    
    /**
     * Get all the peticiones by usuario id.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
    public List<PeticionDTO> findAllByIdUsuario(Long idUsuario){
        return ModelMapperUtils.mapAll(this.peticionRepository.findAllByIdUsuario(idUsuario), PeticionDTO.class);

    }

    /**
     * Get one peticion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PeticionDTO> findOne(Long id) {
        log.debug("Request to get Peticion : {}", id);
        return Optional.of(ModelMapperUtils.map(peticionRepository.findById(id).get(), PeticionDTO.class));

    }

    /**
     * Delete the peticion by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Peticion : {}", id);
        peticionRepository.deleteById(id);
    }

}
