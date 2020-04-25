package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.PeticionService;
import com.hackathlon.heronation.domain.Peticion;
import com.hackathlon.heronation.repository.PeticionRepository;
import com.hackathlon.heronation.service.dto.PeticionDTO;
import com.hackathlon.heronation.service.mapper.PeticionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Peticion}.
 */
@Service
@Transactional
public class PeticionServiceImpl implements PeticionService {

    private final Logger log = LoggerFactory.getLogger(PeticionServiceImpl.class);

    private final PeticionRepository peticionRepository;

    private final PeticionMapper peticionMapper;

    public PeticionServiceImpl(PeticionRepository peticionRepository, PeticionMapper peticionMapper) {
        this.peticionRepository = peticionRepository;
        this.peticionMapper = peticionMapper;
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
        Peticion peticion = peticionMapper.toEntity(peticionDTO);
        peticion = peticionRepository.save(peticion);
        return peticionMapper.toDto(peticion);
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
        return peticionRepository.findAll().stream()
            .map(peticionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
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
        return peticionRepository.findById(id)
            .map(peticionMapper::toDto);
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
