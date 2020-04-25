package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.PoblacionService;
import com.hackathlon.heronation.domain.Poblacion;
import com.hackathlon.heronation.repository.PoblacionRepository;
import com.hackathlon.heronation.service.dto.PoblacionDTO;
import com.hackathlon.heronation.service.mapper.PoblacionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Poblacion}.
 */
@Service
@Transactional
public class PoblacionServiceImpl implements PoblacionService {

    private final Logger log = LoggerFactory.getLogger(PoblacionServiceImpl.class);

    private final PoblacionRepository poblacionRepository;

    private final PoblacionMapper poblacionMapper;

    public PoblacionServiceImpl(PoblacionRepository poblacionRepository, PoblacionMapper poblacionMapper) {
        this.poblacionRepository = poblacionRepository;
        this.poblacionMapper = poblacionMapper;
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
        Poblacion poblacion = poblacionMapper.toEntity(poblacionDTO);
        poblacion = poblacionRepository.save(poblacion);
        return poblacionMapper.toDto(poblacion);
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
        return poblacionRepository.findAll().stream()
            .map(poblacionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
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
        return poblacionRepository.findById(id)
            .map(poblacionMapper::toDto);
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
