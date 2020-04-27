package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.RolService;
import com.hackathlon.heronation.model.Rol;
import com.hackathlon.heronation.repository.RolRepository;
import com.hackathlon.heronation.model.dto.RolDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Rol}.
 */
@Service
@Transactional
public class RolServiceImpl implements RolService {

    private final Logger log = LoggerFactory.getLogger(RolServiceImpl.class);

    @Autowired
    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    /**
     * Save a rol.
     *
     * @param rolDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public RolDTO save(RolDTO rolDTO) {
        log.debug("Request to save Rol : {}", rolDTO);
        Rol rol = ModelMapperUtils.map(rolDTO, Rol.class);
        rol = rolRepository.save(rol);
        return ModelMapperUtils.map(rol, RolDTO.class);
    }

    /**
     * Get all the rols.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<RolDTO> findAll() {
        log.debug("Request to get all Rols");
        return ModelMapperUtils.mapAll(rolRepository.findAll(), RolDTO.class);

    }

    /**
     * Get one rol by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RolDTO> findOne(Long id) {
        log.debug("Request to get Rol : {}", id);
        return Optional.of(ModelMapperUtils.map(rolRepository.findById(id).get(), RolDTO.class));

    }

    /**
     * Delete the rol by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Rol : {}", id);
        rolRepository.deleteById(id);
    }
}
