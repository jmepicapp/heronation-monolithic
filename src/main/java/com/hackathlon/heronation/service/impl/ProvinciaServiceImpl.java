package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.ProvinciaService;
import com.hackathlon.heronation.model.Provincia;
import com.hackathlon.heronation.repository.ProvinciaRepository;
import com.hackathlon.heronation.model.dto.ProvinciaDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Provincia}.
 */
@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    private final Logger log = LoggerFactory.getLogger(ProvinciaServiceImpl.class);

    @Autowired
    private final ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    /**
     * Save a provincia.
     *
     * @param provinciaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ProvinciaDTO save(ProvinciaDTO provinciaDTO) {
        log.debug("Request to save Provincia : {}", provinciaDTO);
        Provincia provincia = ModelMapperUtils.map(provinciaDTO, Provincia.class);
        provincia = provinciaRepository.save(provincia);
        return ModelMapperUtils.map(provincia, ProvinciaDTO.class);
    }

    /**
     * Get all the provincias.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProvinciaDTO> findAll() {
        log.debug("Request to get all Provincias");
        return ModelMapperUtils.mapAll(provinciaRepository.findAll(), ProvinciaDTO.class);

    }

    /**
     * Get one provincia by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProvinciaDTO> findOne(Long id) {
        log.debug("Request to get Provincia : {}", id);
        return Optional.of(ModelMapperUtils.map(provinciaRepository.findById(id), ProvinciaDTO.class));

    }

    /**
     * Delete the provincia by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Provincia : {}", id);
        provinciaRepository.deleteById(id);
    }
}
