package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.DireccionService;
import com.hackathlon.heronation.model.Direccion;
import com.hackathlon.heronation.repository.DireccionRepository;
import com.hackathlon.heronation.model.dto.DireccionDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Direccion}.
 */
@Service
@Transactional
public class DireccionServiceImpl implements DireccionService {

    private final Logger log = LoggerFactory.getLogger(DireccionServiceImpl.class);

    @Autowired
    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    /**
     * Save a direccion.
     *
     * @param direccionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DireccionDTO save(DireccionDTO direccionDTO) {
        log.debug("Request to save Direccion : {}", direccionDTO);
        Direccion direccion = ModelMapperUtils.map(direccionDTO, Direccion.class);
        direccion = direccionRepository.save(direccion);
        return ModelMapperUtils.map(direccion, DireccionDTO.class);
    }

    /**
     * Get all the direccions.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<DireccionDTO> findAll() {
        log.debug("Request to get all Direccions");
        return ModelMapperUtils.mapAll(direccionRepository.findAll(), DireccionDTO.class);

    }

    /**
     * Get one direccion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DireccionDTO> findOne(Long id) {
        log.debug("Request to get Direccion : {}", id);
        return Optional.of(ModelMapperUtils.map(direccionRepository.findById(id), DireccionDTO.class));

    }

    /**
     * Delete the direccion by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Direccion : {}", id);
        direccionRepository.deleteById(id);
    }
}
