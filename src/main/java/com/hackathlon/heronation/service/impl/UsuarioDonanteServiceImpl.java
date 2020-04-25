package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.UsuarioDonanteService;
import com.hackathlon.heronation.model.UsuarioDonante;
import com.hackathlon.heronation.repository.UsuarioDonanteRepository;
import com.hackathlon.heronation.model.dto.UsuarioDonanteDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link UsuarioDonante}.
 */
@Service
@Transactional
public class UsuarioDonanteServiceImpl implements UsuarioDonanteService {

    private final Logger log = LoggerFactory.getLogger(UsuarioDonanteServiceImpl.class);

    private final UsuarioDonanteRepository usuarioDonanteRepository;

    public UsuarioDonanteServiceImpl(UsuarioDonanteRepository usuarioDonanteRepository) {
        this.usuarioDonanteRepository = usuarioDonanteRepository;
    }

    /**
     * Save a usuarioDonante.
     *
     * @param usuarioDonanteDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UsuarioDonanteDTO save(UsuarioDonanteDTO usuarioDonanteDTO) {
        log.debug("Request to save UsuarioDonante : {}", usuarioDonanteDTO);
        UsuarioDonante usuarioDonante = ModelMapperUtils.map(usuarioDonanteDTO, UsuarioDonante.class);
        usuarioDonante = usuarioDonanteRepository.save(usuarioDonante);
        return ModelMapperUtils.map(usuarioDonante, UsuarioDonanteDTO.class);
    }

    /**
     * Get all the usuarioDonantes.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDonanteDTO> findAll() {
        log.debug("Request to get all UsuarioDonantes");
        return ModelMapperUtils.mapAll(usuarioDonanteRepository.findAll(), UsuarioDonanteDTO.class);

    }

    /**
     * Get one usuarioDonante by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDonanteDTO> findOne(Long id) {
        log.debug("Request to get UsuarioDonante : {}", id);
        return Optional.of(ModelMapperUtils.map(usuarioDonanteRepository.findById(id), UsuarioDonanteDTO.class));

    }

    /**
     * Delete the usuarioDonante by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UsuarioDonante : {}", id);
        usuarioDonanteRepository.deleteById(id);
    }
}
