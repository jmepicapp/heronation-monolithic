package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.PreferenciaService;
import com.hackathlon.heronation.model.Preferencia;
import com.hackathlon.heronation.repository.PreferenciaRepository;
import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Preferencia}.
 */
@Service
@Transactional
public class PreferenciaServiceImpl implements PreferenciaService {

    private final Logger log = LoggerFactory.getLogger(PreferenciaServiceImpl.class);

    private final PreferenciaRepository preferenciaRepository;

    public PreferenciaServiceImpl(PreferenciaRepository preferenciaRepository) {
        this.preferenciaRepository = preferenciaRepository;
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
        Preferencia preferencia = ModelMapperUtils.map(preferenciaDTO, Preferencia.class);
        preferencia = preferenciaRepository.save(preferencia);
        return ModelMapperUtils.map(preferenciaRepository, PreferenciaDTO.class);
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
        return ModelMapperUtils.mapAll(preferenciaRepository.findAll(), PreferenciaDTO.class);

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
        return Optional.of(ModelMapperUtils.map(preferenciaRepository.findById(id), PreferenciaDTO.class));

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
