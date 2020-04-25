package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.PreferenciaService;
import com.hackathlon.heronation.domain.Preferencia;
import com.hackathlon.heronation.repository.PreferenciaRepository;
import com.hackathlon.heronation.service.dto.PreferenciaDTO;
import com.hackathlon.heronation.service.mapper.PreferenciaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Preferencia}.
 */
@Service
@Transactional
public class PreferenciaServiceImpl implements PreferenciaService {

    private final Logger log = LoggerFactory.getLogger(PreferenciaServiceImpl.class);

    private final PreferenciaRepository preferenciaRepository;

    private final PreferenciaMapper preferenciaMapper;

    public PreferenciaServiceImpl(PreferenciaRepository preferenciaRepository, PreferenciaMapper preferenciaMapper) {
        this.preferenciaRepository = preferenciaRepository;
        this.preferenciaMapper = preferenciaMapper;
    }

    /**
     * Save a preferencia.
     *
     * @param preferenciaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PreferenciaDTO save(PreferenciaDTO preferenciaDTO) {
        log.debug("Request to save Preferencia : {}", preferenciaDTO);
        Preferencia preferencia = preferenciaMapper.toEntity(preferenciaDTO);
        preferencia = preferenciaRepository.save(preferencia);
        return preferenciaMapper.toDto(preferencia);
    }

    /**
     * Get all the preferencias.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PreferenciaDTO> findAll() {
        log.debug("Request to get all Preferencias");
        return preferenciaRepository.findAll().stream()
            .map(preferenciaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one preferencia by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PreferenciaDTO> findOne(Long id) {
        log.debug("Request to get Preferencia : {}", id);
        return preferenciaRepository.findById(id)
            .map(preferenciaMapper::toDto);
    }

    /**
     * Delete the preferencia by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Preferencia : {}", id);
        preferenciaRepository.deleteById(id);
    }
}
