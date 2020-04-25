package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.PoblacionService;
import com.hackathlon.heronation.model.Poblacion;
import com.hackathlon.heronation.repository.PoblacionRepository;
import com.hackathlon.heronation.model.dto.PoblacionDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Poblacion}.
 */
@Service
@Transactional
public class PoblacionServiceImpl implements PoblacionService {

    private final Logger log = LoggerFactory.getLogger(PoblacionServiceImpl.class);

    private final PoblacionRepository poblacionRepository;

    public PoblacionServiceImpl(PoblacionRepository poblacionRepository) {
        this.poblacionRepository = poblacionRepository;
    }

    /**
     * Save a poblacion.
     *
     * @param poblacionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PoblacionDTO save(PoblacionDTO poblacionDTO) {
        log.debug("Request to save Poblacion : {}", poblacionDTO);
        Poblacion poblacion = ModelMapperUtils.map(poblacionDTO, Poblacion.class);
        poblacion = poblacionRepository.save(poblacion);
        return ModelMapperUtils.map(poblacion, PoblacionDTO.class);
    }

    /**
     * Get all the poblacions.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PoblacionDTO> findAll() {
        log.debug("Request to get all Poblacions");
        return ModelMapperUtils.mapAll(poblacionRepository.findAll(), PoblacionDTO.class);
    }

    /**
     * Get one poblacion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PoblacionDTO> findOne(Long id) {
        log.debug("Request to get Poblacion : {}", id);
        return Optional.of(ModelMapperUtils.map(poblacionRepository.findById(id), PoblacionDTO.class));

    }

    /**
     * Delete the poblacion by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Poblacion : {}", id);
        poblacionRepository.deleteById(id);
    }
}
